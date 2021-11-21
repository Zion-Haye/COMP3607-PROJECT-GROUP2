//import java.util.ArrayList;
package com.example;

public class FileFixer {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // CSV Reader
        CSVFileReader csvFileReader = new CSVFileReader();



        String filePath = "lib/filesToRename/Sample 3 CSV.csv";// remove
        String filePath2 = "lib/filesToRename/Sample 5 CSV.csv";// remove

        StudentCollection studentData = csvFileReader.readFile(filePath);// ?
        IIterator studentIter = studentData.createIterator();

        // Student Data Test
        // for (Student student : studentData) {
        // System.out.println(student.toString());
        // }

        // Folder Reader
        FolderReader folderReader = new FolderReader();
        
        String folderPath = "lib/filesToRename";// remove
        String folderPath2 = "lib/filesToRename2";// remove

        FileCollection files = folderReader.readFolder(folderPath);// ???

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
