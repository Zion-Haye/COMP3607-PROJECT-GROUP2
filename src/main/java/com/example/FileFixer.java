//import java.util.ArrayList;
package com.example;

public class FileFixer {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // CSV Reader
        CSVFileReader csvFileReader = new CSVFileReader();
        StudentCollection studentData = csvFileReader.readFile();// ?
        IIterator studentIter = studentData.createIterator();

        // Student Data Test
        // for (Student student : studentData) {
        // System.out.println(student.toString());
        // }

        // Folder Reader
        FolderReader folderReader = new FolderReader();
        FileCollection files = folderReader.readFolder();// ???
        IIterator fileIter = files.createIterator();

        // FileItem test = (FileItem) testIter.getItem(new Student("*", "Cory Chin Pan
        // Tan", "*"));
        // System.out.print(test.getName());

        Renamer fileRenamer = new Renamer(studentIter, fileIter);
        fileRenamer.renameFiles();

        FileProcessor.MissingFiles(studentIter);

        // Make Folder Test
        // FolderWriter folderWriter = new FolderWriter();
        // folderWriter.initialiseFolder();
    }
}
