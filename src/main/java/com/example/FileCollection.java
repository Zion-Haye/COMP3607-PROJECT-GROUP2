package com.example;

import java.util.ArrayList;

public class FileCollection implements IContainer { // Concrete Aggregate File COllection
    private static ArrayList<PDFFileTemplate> files; //Static List so that the collection won't need to be returned
    private static boolean listCreated = false; //To know whether a list have already been created

    public FileCollection() {//Constructor
        if (!listCreated){
            files = new ArrayList<PDFFileTemplate>();
            listCreated = true;
        }
    }

    public void addToFiles(PDFFileTemplate newFile) {//Add file to collection
        files.add(newFile);
    }

    
    @Override
    public IIterator createIterator() { //To create the iterator
        FileIterator results = new FileIterator();
        return results;
    }

    private class FileIterator implements IIterator {//Making a private concrete file iterator
        private int position = 0;

        public boolean hasNext() {
            if (position < files.size()) {
                return true;
            } else {
                position = 0;
                return false;
            }
        }

        public Object getItem(Object obj) {// searching in multiple different ways to find the file
            Student student = (Student) obj;
            //first by Participant ID
            PDFFileTemplate test = (PDFFileTemplate) getItemByParticipantID(student.getParticipantIdentifierNum());
            //then by Student ID
            if (test == null)
                test = (PDFFileTemplate) getItemByStudentID(student.getIdNumber());
            //finally by student's full name
            if (test == null)
                test = (PDFFileTemplate) getItemByName(student.getFullName());
            return test;
        }

        private Object getItemByParticipantID(String participantID) {//Searching by Participant ID

            for (PDFFileTemplate test : files) {
                String testName = test.getName();
                if (testName.contains(participantID))
                    return test;
            }
            return null;
        }

        private Object getItemByStudentID(String studentID) {//Searching by Student ID

            for (PDFFileTemplate test : files) {
                String testName = test.getName();
                if (testName.contains(studentID))
                    return test;
            }
            return null;
        }

        private Object getItemByName(ArrayList<String> names) {//Searching by Name
            boolean equals;
            for (PDFFileTemplate test : files) {
                equals = true;
                String testName = test.getName().toLowerCase();
                for (String name : names)
                    if (!testName.contains(name.toLowerCase())) {
                        equals = false;
                        break;
                    }
                if (equals)
                    return test;
            }
            return null;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return files.get(position++);
            } else {
                return null;
            }
        }

    }

}
