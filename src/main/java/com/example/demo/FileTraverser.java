package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileTraverser {
    public static void main(String[] args) throws IOException {
        // Set the path to the root directory to search in
        String rootPath = "C:/Users/pawan/Documents";

        // Create a new Excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a new worksheet
        Sheet worksheet = workbook.createSheet("Files");

        // Create a header row
        Row headerRow = worksheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("File Name");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("File Path");

        // Call the traverseDirectory method to traverse the directory and add the file names and paths to the worksheet
        try {
            traverseDirectory(new File(rootPath), worksheet);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Write the workbook to a file
        FileOutputStream outputStream = new FileOutputStream("C:/Users/pawan/Documents/output.xlsx");
        workbook.write(outputStream);
        workbook.close();
    }

    private static void traverseDirectory(File directory, Sheet worksheet) {
        // Get a list of all the files in the directory
        File[] files = directory.listFiles();

        // Check if files is null (i.e. the directory does not exist or is not accessible)
        if (files == null) {
            return;
        }

        // Loop through each file in the directory
        for (File file : files) {
            if (file.isDirectory()) {
                // If the file is a directory, recursively call the traverseDirectory method
                traverseDirectory(file, worksheet);
            } else {
                // If the file is a file, add the file name and path to the worksheet
                Row row = worksheet.createRow(worksheet.getLastRowNum() + 1);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(file.getName());
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(file.getAbsolutePath());
            }
        }
    }
}

