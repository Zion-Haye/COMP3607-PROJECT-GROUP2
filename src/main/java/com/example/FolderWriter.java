package com.example;

import java.io.File;

public class FolderWriter {
   

    public static void initialiseFolder() {//Initializing the folder to rename the files

        String folderPath = "lib/filesToRename/renamedFiles";
        File folder = new File(folderPath);

        if (!folder.exists()) {
            File file = new File(folderPath);
            file.mkdirs();
        }

    }
}
