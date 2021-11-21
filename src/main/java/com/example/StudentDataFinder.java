package com.example;

import java.io.File;
import java.util.ArrayList;

public class StudentDataFinder {

    public ArrayList<String> findStudentName(File fileItem, String currData, StudentCollection studentData) {
        String fileItemName = fileItem.getName();
        IIterator studentIter = studentData.createIterator();

        while (studentIter.hasNext()) {
            Student student = (Student) studentIter.next();
            String fullName = student.getFullNameString();
            String fName = student.getFullName().get(0);
            String lName = student.getFullName().get(1);

            if (currData == null) {
                if (fileItemName.toLowerCase().contains(fullName.toLowerCase())
                        || ((fileItemName.toLowerCase().contains(fName.toLowerCase())
                                && fileItemName.toLowerCase().contains(lName.toLowerCase())))) {
                    return student.getFullName();
                }
            } else {
                if (student.getIdNumber().equals(currData)) {
                    return student.getFullName();
                }
            }
        }
        return null;
    }

    public String findStudentID(File fileItem, ArrayList<String> currData, StudentCollection studentData) {
        String fileItemName = fileItem.getName();
        IIterator studentIter = studentData.createIterator();

        while (studentIter.hasNext()) {
            Student student = (Student) studentIter.next();

            if (currData == null) {
                if (fileItemName.contains(student.getIdNumber())) {
                    return student.getIdNumber();
                }
            } else { // if you didn't find the student id from the filename
                if (student.getFullNameString().contains(currData.get(0))
                        && student.getFullNameString().contains(currData.get(1))) {
                    return student.getIdNumber();
                }
            }
        }

        return null;
    }

}
