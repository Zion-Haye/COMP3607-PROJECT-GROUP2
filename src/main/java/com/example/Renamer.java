package com.example;


public class Renamer {
    IIterator fileIterator;
    IIterator studentIterator;

    public Renamer(IIterator students, IIterator files) {//Constructor
        fileIterator = files;
        studentIterator = students;
    }

    public void renameFiles() {// for each studen searches through the files to rename
        FolderWriter.initialiseFolder();

        while (studentIterator.hasNext()) {
            Student newStudent = (Student) studentIterator.next();
            PDFFileTemplate newFileItem = (PDFFileTemplate) fileIterator.getItem(newStudent);

            if (newFileItem != null) {//if it is found then rename the file
                newFileItem.renameFile(newFileName(newStudent));
                newStudent.setFound(true);
            } else {
                System.out.println("#########File not found");
            }

        }
    }

    private String newFileName(Student stu) {// creating the submission file name
        String newFile = stu.getFullNameString() + "_";
        newFile += stu.getParticipantIdentifierNum() + "_";
        newFile += "assignsubmission_file_";
        return newFile;
    }

}
