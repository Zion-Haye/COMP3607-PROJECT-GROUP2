//import java.util.ArrayList;
package com.example;

public class FileFixer { //Main Class
    public static void main(String[] args) throws Exception {
        
        FolderReader folderReader = new FolderReader(); 
        String folderPath = "lib/filesToRename";
        
        folderReader.readFolder(folderPath);
        
        FileCollection files = new FileCollection();
        StudentCollection students = new StudentCollection();

        IIterator studentIter = students.createIterator();
        IIterator fileIter = files.createIterator();
        

        Renamer fileRenamer = new Renamer(studentIter, fileIter);
        fileRenamer.renameFiles();

        FileProcessor.MissingFiles(studentIter);

    }
}
