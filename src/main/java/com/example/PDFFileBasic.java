package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class PDFFileBasic extends PDFFileTemplate {

    public PDFFileBasic(File file) {
        super(file);
    }

    @Override
    public void renameFile(String newFileName) {
        Boolean isRenamed;
        // String fileName = "lib/renamedFiles/test.docx";

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
            System.out.println(file.getPath());
            System.out.println(newFileDirectory + seperator + newFileName + getAssignmentFileName() + "\n");
        }

        
    }

    @Override
    protected void getImportantDetails() {
        ArrayList<String> fullFileName = new ArrayList<String>(Arrays.asList(getName().split("_")));

        // ArrayList<String> importantDetails = new ArrayList<String>();

        int x;
        for (x = 1; !NumChecker.isNumeric(fullFileName.get(x)); x++)
            namesList.add(fullFileName.get(x));

        x++;
        assignmentFileName = fullFileName.get(x++);
        while (x < fullFileName.size())
            assignmentFileName += "_" + fullFileName.get(x++);
        
    }
    
}
