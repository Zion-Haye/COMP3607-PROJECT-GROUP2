package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFileReader{
    private static File file = null;
    
    public void saveLatestFile(File newFile){
        if (file.lastModified() < newFile.lastModified())
            file = newFile;
    }
    public CSVFileReader(File newFile){
        if (newFile.getName().contains("._")){//Skipping MacTempFile
            System.out.println("Invalid CSV");
        }
        else if (file == null)  //if it is the first valid file we make this the one saved
            file = newFile;
        else                    //keeps the csv that was last modified
            saveLatestFile(newFile);
    } 

    public void readFile() {//Reading students from csv file into student collection

        //Initialization
        ArrayList<String> studentRecord;
        StudentCollection studentLists = new StudentCollection();

        Student student;

        String line = ""; 
        int counter = 1;

        //Reading frfom the file
        try {
            FileReader fr = new FileReader(file);
            // Create File reader and pass filepath

            BufferedReader br = new BufferedReader(fr);
            // Create Buffer reader and pass file reader

            while ((line = br.readLine()) != null) { // checks next line
    
                studentRecord = new ArrayList<String>(Arrays.asList(line.split(",")));

                // Making sure the id / names are in the record
                if (!(studentRecord.get(0).isEmpty() || studentRecord.get(1).isEmpty()))
                    if (counter > 1) { //skipping the header row
                        ArrayList<String> participantIDDetails = new ArrayList<String>(
                                Arrays.asList(studentRecord.get(0).split("\\s+")));
                        
                        student = new Student(participantIDDetails.get(1), studentRecord.get(1), studentRecord.get(2));
                        studentLists.addToStudents(student);
                    }

                counter++;
            }
            br.close();
        // Catching errors Error if the file is not found
        } catch (FileNotFoundException e) {  
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
