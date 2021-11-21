package com.example;

import java.util.ArrayList;

public class StudentCollection implements IContainer {
    private ArrayList<Student> students;

    public StudentCollection() {
        students = new ArrayList<Student>();
    }

    public void addToStudents(Student newStudent) {
        students.add(newStudent);
    }

    @Override
    public IIterator createIterator() {
        StudentIterator results = new StudentIterator();
        return results;
    }

    private class StudentIterator implements IIterator {
        private int position = 0;

        public boolean hasNext() {
            if (position < students.size()) {
                return true;
            } else {
                position = 0;
                return false;
            }
        }

        @Override
        public Object getItem(Object obj) {
            int index = (int) obj;
            return students.get(index);
        }

        /*
         * public Object getItemByName(String fName, String lName) { for (Student test :
         * students){ if (fName.equals(test.getFirstName()) &&
         * lName.equals(test.getLastName())){ return test; } } return null; }
         */
        @Override
        public Object next() {
            if (this.hasNext()) {
                return students.get(position++);
            } else {
                return null;
            }
        }

    }

}
