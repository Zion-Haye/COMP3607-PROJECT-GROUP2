package com.example;

import java.io.File;
import java.io.FileNotFoundException;

public class FolderReader {

    public FileCollection readFolder(String folderPath) {
        // Thoughts
        FileCollection fileList = new FileCollection();
        // try catch error folder File Not Found Exception?

        // Create object and parse dolfer path
        //String folderPath = "lib/fileToRename";
        //String folderPath2 = "lib/fileToRename2";

        // try{

        File folder = new File(folderPath);

        if (folder.exists()) {

            File[] files = folder.listFiles();

            for (File file : files) {

                if (file.isFile()) {
                    // check if file

                    // System.out.println(file.getName() + "\n");

                    // FileProcessor fileProcessor = new FileProcessor();
                    // fileProcessor.getFileName(file);

                    if (file.getName().contains(".pdf")) {
                        FileItem fileItem = new FileItem(file);
                        fileList.addToFiles(fileItem);
                        System.out.println("\n\n" + fileItem.getName());
                        // fileItem.printImportantDetails();
                    }

                    // print file name
                }

                if (file.isDirectory()) {
                    // check if directory
                }
            }

        } else {
            System.out.println("Folder Does Not Exist.");
        }
        /*
         * IIterator fileIterator = fileList.createIterator(); /*while
         * (fileIterator.hasNext()){ FileItem test = (FileItem) fileIterator.next(); if
         * (test != null) System.out.println(test.getName()); }
         */
        /*
         * FileItem test = (FileItem) fileIterator.getItem("41856", "Drew", "Jenkins");
         * if (test != null) System.out.println(test.getName());
         */
        return fileList;

        // }catch(FileNotFoundException e){
        // e.printStackTrace();
        // }
    }

}
