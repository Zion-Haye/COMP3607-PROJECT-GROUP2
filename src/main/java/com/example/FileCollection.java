package com.example;

import java.util.ArrayList;

public class FileCollection implements IContainer {
    private static ArrayList<PDFFileTemplate> files;
    private static boolean listCreated = false;

    public FileCollection() {
        if (!listCreated){
            files = new ArrayList<PDFFileTemplate>();
            listCreated = true;
        }
        //System.out.println(files);
    }

    public void addToFiles(PDFFileTemplate newFile) {
        files.add(newFile);
    }

    @Override
    public IIterator createIterator() {
        FileIterator results = new FileIterator();
        return results;
    }

    private class FileIterator implements IIterator {
        private int position = 0;

        public boolean hasNext() {
            if (position < files.size()) {
                return true;
            } else {
                position = 0;
                return false;
            }
        }

        public Object getItem(Object obj) {
            Student student = (Student) obj;
            PDFFileTemplate test = (PDFFileTemplate) getItemByID(student.getParticipantIdentifierNum());
            if (test == null)
                test = (PDFFileTemplate) getItemByName(student.getFullName());
            return test;
        }

        private Object getItemByID(String participantID) {

            for (PDFFileTemplate test : files) {
                String testName = test.getName();
                if (testName.contains(participantID))
                    return test;
            }
            return null;
        }

        private Object getItemByName(ArrayList<String> names) {
            boolean equals;
            for (PDFFileTemplate test : files) {
                equals = true;
                String testName = test.getName();
                for (String name : names)
                    if (!testName.contains(name)) {
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
