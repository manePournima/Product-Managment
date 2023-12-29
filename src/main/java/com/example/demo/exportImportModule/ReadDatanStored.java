package com.example.demo.exportImportModule;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDatanStored {
	
	
	private static List<List<String>> readAllExcelFiles(String folderPath) throws IOException {
        List<List<String>> allData = new ArrayList<>();

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".xlsx"));

        if (files != null) {
            for (File file : files) {
                List<String> data = readExcelFile(file);
                allData.add(data);
            }
        }

        return allData;
    }
	

    private static List<String> readExcelFile(File file) throws IOException {
        List<String> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Assuming data is in the first column of each row
                Cell cell = row.getCell(0);
                if (cell != null) {
                    data.add(cell.toString());
                }
            }
        }

        return data;
    }

    private static List<String> combineData(List<List<String>> allData) {
        List<String> combinedData = new ArrayList<>();
        for (List<String> data : allData) {
            combinedData.addAll(data);
        }
        return combinedData;
    }

    private static void writeCombinedDataToExcel(List<String> data, String outputPath) throws IOException {
        String outputFolderPath = "src/data";
        String outputFileFullPath = outputFolderPath + File.separator + outputPath;

        File outputFolder = new File(outputFolderPath);
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();  // Create the output folder if it doesn't exist
        }

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(outputFileFullPath)) {
 
            Sheet sheet = workbook.createSheet("Combined Data");

            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                 cell.setCellValue(data.get(i));
            }

            workbook.write(fos);
        }
    }

    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		String folderPath = "src/data"; // Specify the path to your folder containing Excel files

        try {
            List<List<String>> allData = readAllExcelFiles(folderPath);

            // Print the number of files
            System.out.println("Number of Excel files: " + allData.size());

            // Combine data from all files
            List<String> combinedData = combineData(allData);

            // Write combined data to a new Excel file
            writeCombinedDataToExcel(combinedData, "combined_output.xlsx");

            System.out.println("Data from all files has been combined and stored in 'combined_output.xlsx'");
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
