package com.example;

import java.io.File;

public class FolderWriter {
    // Methods initialise - check if folder exists , if not create one
    // Takes in collection of files
    // write to file.

    public static void initialiseFolder() {

        String folderPath = "lib/filesToRename/renamedFiles";
        File folder = new File(folderPath);

        if (!folder.exists()) {
            File file = new File(folderPath);
            file.mkdirs();
        }

        /*
         * String directoryName = "lib/fileToRename/folderTest"; File file = new
         * File(directoryName); file.mkdirs();
         */

        /*
         * if (folder.exists()) { System.out.println("Folder exists"); } else {
         * System.out.println("Folder Does not exist"); }
         */

    }
}
