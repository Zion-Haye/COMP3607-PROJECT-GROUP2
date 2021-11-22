package com.example;

import java.io.File;
import java.util.ArrayList;


public abstract class PDFFileTemplate {
    // leaf

    protected File file;
    protected ArrayList<String> namesList;
    protected String assignmentFileName;
    // String extractedData;

    public PDFFileTemplate(File file) {
        this.file = file;
        namesList = new ArrayList<String>();
        getImportantDetails();
    }

    public String getName() {
        return file.getName();
    }


    public ArrayList<String> getstudentNames() {
        return namesList;
    }

    public String getAssignmentFileName() {
        return assignmentFileName;
    }

    public abstract void renameFile(String newFileName);

    protected abstract void getImportantDetails();

    public void printImportantDetails() {
        String names = "";
        for (String name : namesList)
            names += name + " ";
        System.out.println("Important Details: " + "\nName: " + names + "\nOriginal File Name: "
                + assignmentFileName);

        // System.out.println(getImportantDetails() + "\n\n");
    }

    public String toString(){
        return file.getName() + "\n";
    }

    // get file extension?

}
