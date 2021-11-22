package com.example;

import java.util.ArrayList;


public class StudentCollection implements IContainer { // Concrete Aggregate Student Collection
    private static ArrayList<Student> students;//Static List so that the collection won't need to be returned
    private static boolean listCreated = false;//To know whether a list have already been created

    public StudentCollection() {
        System.out.println(students);
        if (!listCreated)
            students = new ArrayList<Student>();
        listCreated = true;
    }

    public void addToStudents(Student newStudent) {//Add student to collection
        students.add(newStudent);
    }

    @Override
    public IIterator createIterator() {//To create the iterator
        StudentIterator results = new StudentIterator();
        return results;
    }

    private class StudentIterator implements IIterator {//Making a private concrete file iterator
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
        public Object getItem(Object obj) {// Getting Student by indext in collection
            int index = (int) obj;
            return students.get(index);
        }

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
