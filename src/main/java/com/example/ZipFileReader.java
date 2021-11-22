package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ZipFileReader {
    File file;

    public ZipFileReader(File file) {
        this.file = file;
    }

    public void unZipArchive() throws IOException {
        byte[] buffer = new byte[1024];
        ZipInputStream unZipper = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = unZipper.getNextEntry();
        
        while (entry != null){
            File newFile = new File(file.getParent() + File.separator + entry.getName());
            if (entry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // fix for Windows-created archives
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }
                
                // write file content
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = unZipper.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
        entry = unZipper.getNextEntry();

        }
        unZipper.closeEntry();
        
        unZipper.close();
    }

    
}
