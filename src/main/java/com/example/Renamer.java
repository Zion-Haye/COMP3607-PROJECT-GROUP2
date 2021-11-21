package com.example;

public class Renamer {
    IIterator fileIterator;
    IIterator studentIterator;

    public Renamer(IIterator students, IIterator files) {
        fileIterator = files;
        studentIterator = students;
    }

    public void renameFiles() {
        FolderWriter.initialiseFolder();

        while (studentIterator.hasNext()) {
            Student newStudent = (Student) studentIterator.next();
            FileItem newFileItem = (FileItem) fileIterator.getItem(newStudent);
            // (newStudent.getIdNumber(), newStudent.getFirstName(),
            // newStudent.getLastName());

            if (newFileItem != null) {
                newFileItem.renameFile(newFileName(newStudent));
                newStudent.setFound(true);
            } else {
                System.out.println("#########File not found");
            }

        }
    }

    private String newFileName(Student stu) {
        String newFile = stu.getFullNameString() + "_";
        newFile += stu.getParticipantIdentifierNum() + "_";
        newFile += "assignsubmission_file_";
        return newFile;
    }

}
