package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FolderReader {
    FileCollection fileList = new FileCollection();
    CSVFileReader csv;

    public void readFolder(String folderPath) {
        // Thoughts
       
        // try catch error folder File Not Found Exception?

        // Create object and parse dolfer path
        //String folderPath = "lib/fileToRename";
        //String folderPath2 = "lib/fileToRename2";

        // try{

        File folder = new File(folderPath);

        if (folder.exists()) {

            File[] files = folder.listFiles();
            ZipFileReader zip;
            

            for (File file: files) if (file.getName().contains(".zip")){
                 zip = new ZipFileReader(file);
                try{
                    zip.unZipArchive();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            processFiles(folder);

            

        } else {
            System.out.println("Folder Does Not Exist.");
        }
        csv.readFile();
        /*
         * IIterator fileIterator = fileList.createIterator(); /*while
         * (fileIterator.hasNext()){ FileItem test = (FileItem) fileIterator.next(); if
         * (test != null) System.out.println(test.getName()); }
         */
        /*
         * FileItem test = (FileItem) fileIterator.getItem("41856", "Drew", "Jenkins");
         * if (test != null) System.out.println(test.getName());
         */
        

        // }catch(FileNotFoundException e){
        // e.printStackTrace();
        // }
    }

    private void processFiles(File folder){
        File[] files = folder.listFiles();

            for (File file : files) {

                if (file.isFile()) {
                 
                    if (file.getName().contains(".pdf")) {
                        PDFFileTemplate fileItem = new PDFFileTemplate(file);
                        fileList.addToFiles(fileItem);
                        //System.out.println("\n\n" + fileItem.getName());
                        // fileItem.printImportantDetails();
                    }else if (file.getName().contains(".csv")){
                        csv = new CSVFileReader(file);
                    }

                }

                if (file.isDirectory()) {
                    processFiles(file);
                }
            }
    }

}
