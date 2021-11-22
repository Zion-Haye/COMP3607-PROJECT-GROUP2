package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class PDFFileBasic extends PDFFileTemplate { // PDF Basic File

    public PDFFileBasic(File file) { //Constructor
        super(file);
    }

    @Override
    public void renameFile(String newFileName) {// Rename file using File Name
        Boolean isRenamed;

        String seperator = File.separator;
        String newFileDirectory = "lib" + seperator + "filesToRename" + seperator + "renamedFiles";
        
        File newFile = new File(newFileDirectory + seperator + newFileName + getAssignmentFileName()); // takes in file
                                                                                                       // path

        File f = new File(newFileDirectory);
        f.mkdirs();

        isRenamed = file.renameTo(newFile); // take in file , returns bool
    

        if (isRenamed) {//If the renaming was successful
            file = newFile;
            System.out.println("Rename Successful!");
        } else {
            System.out.println("Rename Failed!");
            System.out.println(newFileDirectory + seperator + newFileName + getAssignmentFileName() + "\n");
        }

        
    }

    @Override
    protected void getImportantDetails() {//getting the Assignment file Name
        ArrayList<String> fullFileName = new ArrayList<String>(Arrays.asList(getName().split("_")));

        // ArrayList<String> importantDetails = new ArrayList<String>();

        int x;
        for (x = 1; !NumChecker.isNumeric(fullFileName.get(x)); x++){
            //go Till the Student ID
        }

        x++;
        assignmentFileName = fullFileName.get(x++);
        while (x < fullFileName.size())
            assignmentFileName += "_" + fullFileName.get(x++);
        
    }
    
}
