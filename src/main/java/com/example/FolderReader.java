package com.example;

import java.io.File;
import java.io.IOException;

public class FolderReader {
    FileCollection fileList = new FileCollection();
    CSVFileReader csv;

    public void readFolder(String folderPath) {// Reading the folder for files to rename
        
        File folder = new File(folderPath);

        if (folder.exists()) {

            File[] files = folder.listFiles();
            ZipFileReader zip;
            

            for (File file: files) if (file.getName().contains(".zip")){//Unzipping Archives
                 zip = new ZipFileReader(file);
                try{
                    zip.unZipArchive();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            processFiles(folder);//Processing the files inside the folder

            

        } else {
            System.out.println("Folder Does Not Exist.");
        }
        csv.readFile();
       
    }

    private void processFiles(File folder){//Processing the folders recursively
        File[] files = folder.listFiles();

            for (File file : files) {

                if (file.isFile()) {
                 
                    if (file.getName().contains(".pdf")) {//If it is a pdf check to see what type of pdf

                        PDFFileTemplate fileItem = fileType(file);
                        fileList.addToFiles(fileItem);
                        
                    }else if (file.getName().contains(".csv")){//if it is a csv attempt to add it to the csv reader
                        csv = new CSVFileReader(file);
                    }

                }

                if (file.isDirectory()) {// if it is a folder check the folder for files
                    processFiles(file);
                }
            }


    }

    private PDFFileTemplate fileType(File file){// Checking to see what type of naming convention the file is using
        String fileName = file.getName();
        String[] fileNameParts = fileName.split("_");
        String[] myElearningCode = fileNameParts[0].split("-");
        
        if (fileName.contains("_assignsubmission_file_")){ //  If it follows the convention needed to upload it is a medium file
            return new PDFFileMedium(file);
        }else if (myElearningCode.length>1 && NumChecker.isNumeric(myElearningCode[0])
                    && NumChecker.isNumeric(myElearningCode[1])){ //  If it follows the myElearning convention it is a basic file
            return new PDFFileMedium(file);
        }
        
        return new PDFFileHard(file); // if it is neither of the 2 then it is a raw file
        
    }

}
