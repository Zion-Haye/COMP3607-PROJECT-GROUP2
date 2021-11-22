package com.example;

import java.io.File;


public abstract class PDFFileTemplate {//PDF Template
    

    protected File file;
    protected String assignmentFileName;
    

    public PDFFileTemplate(File file) { // Constructor
        this.file = file;
        getImportantDetails();
    }

    // Getters

    public String getName() {
        return file.getName();
    }


    public String getAssignmentFileName() {
        return assignmentFileName;
    }

    //Abstract Methods
    public abstract void renameFile(String newFileName);

    protected abstract void getImportantDetails();


}
