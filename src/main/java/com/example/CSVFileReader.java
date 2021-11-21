package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFileReader {
    // Notes: last 2 Positions not being displayed

    public StudentCollection readFile() {

        ArrayList<String> studentRecord; // ArrayList for individual Record
        // ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>(); //
        // Array List of ArrayList
        // ArrayList < String[] > table = new ArrayList<String[]>();
        StudentCollection studentLists = new StudentCollection();
        IIterator studentIterator = studentLists.createIterator();
        // ArrayList<Student> studentData = new ArrayList<Student>();

        Student student;

        String filePath = "lib/fileToRename/Sample 3 CSV.csv";
        String filePath2 = "lib/fileToRename/Sample 5 CSV.csv";

        String line = ""; // Line in csv File
        int counter = 1;

        try {
            FileReader fr = new FileReader(filePath2);
            // Create File reader and pass filepath

            BufferedReader br = new BufferedReader(fr);
            // Create Buffer reader and pass file reader

            while ((line = br.readLine()) != null) { // checks next line
                // System.out.println(line);
                studentRecord = new ArrayList<String>(Arrays.asList(line.split(",")));
                // String[] record = line.split(",");
                // System.out.println(record);
                // System.out.println(record.size());

                // System.out.println(record.get(0) + " " + record.get(1) + " " + record.get(2)
                // + "\n");
                // table.add(record);

                // String[] participantIdentifier = studentRecord.get(0).split("//s+");// Get
                // number from participant
                // student = new Student(participantIdentifier[1], studentRecord.get(1),
                // studentRecord.get(2)); // record.
                // String participantID = studentRecord.get(0);
                // String[] participantIDDetails = participantID.split("//s+");

                // ArrayList<String> participantIDDetails = new ArrayList<String>(
                // Arrays.asList(studentRecord.get(0).split(" ")));
                // System.out.println("Test" + participantIDDetails.size());

                // Skip Header Row
                if (!(studentRecord.get(0).isEmpty() || studentRecord.get(1).isEmpty()))
                    if (counter > 1) {
                        ArrayList<String> participantIDDetails = new ArrayList<String>(
                                Arrays.asList(studentRecord.get(0).split("\\s+")));
                        // System.out.println("Test" + participantIDDetails.size());

                        student = new Student(participantIDDetails.get(1), studentRecord.get(1), studentRecord.get(2));
                        studentLists.addToStudents(student);
                    }

                counter++;
            }
            br.close();
            while (studentIterator.hasNext()) {
                Student test = (Student) studentIterator.next();
                if (test != null)
                    System.out.println("###" + test);
            }
            // return table;
            return studentLists;

        } catch (FileNotFoundException e) {
            // Catch Error if the file is not found
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
