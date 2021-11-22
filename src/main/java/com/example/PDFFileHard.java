package com.example;

import java.io.File;

public class PDFFileHard extends PDFFileTemplate {

    public PDFFileHard(File file) {
        super(file);
    }

    @Override
    public void renameFile(String newFileName) {
        Boolean isRenamed;
       

        String seperator = File.separator;
        String newFileDirectory = "lib" + seperator + "filesToRename" + seperator + "renamedFiles";
        
        File newFile = new File(newFileDirectory + seperator + newFileName + getAssignmentFileName()); // takes in file
                                                                                                       // path

        File f = new File(newFileDirectory);
        f.mkdirs();

        isRenamed = file.renameTo(newFile); // take in file , returns bool
    

        if (isRenamed) {
            file = newFile;
            System.out.println("Rename Successful!" + newFileName);
        } else {
            System.out.println("Rename Failed!");
            System.out.println(newFileDirectory + seperator + getAssignmentFileName() + "\n");
        }

        
    }

    @Override
    protected void getImportantDetails() {
        namesList.add("N/A");
        


        assignmentFileName = getName();
        
    }
    
}
