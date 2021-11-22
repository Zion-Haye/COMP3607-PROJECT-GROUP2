package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileProcessor {

    public static void MissingFiles(IIterator students) { // Making file for students that are missing submission files
        String seperator = File.separator;
        String fileName = "lib" + seperator + "filesToRename" + seperator + "Missing file";

        try {
            createFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (students.hasNext()) {//Checking through the students list checking if they have renamed a file yet
            Student test = (Student) students.next();
            if (!test.isFound()) {
                try {
                    appendToFile(fileName, test.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createFile(String fileName) throws IOException {//Creating a new file 
        String str = "Students With Missing Files: \n";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);

        writer.close();
    }

    private static void appendToFile(String fileName, String str) throws IOException {//appending the student to the file

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(str);

        writer.close();
    }

}
