package com.example.demo.exportImportModule;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelFileReadService  {

    public void processExcelFiles(String folderPath, String outputPath) {
        try {
            List<List<String>> allData = readAllExcelFiles(folderPath);

            // Print the number of files
            System.out.println("Number of Excel files: " + allData.size());

            // Combine data from all files
            List<String> combinedData = combineData(allData);

            // Write combined data to a new Excel file
            writeCombinedDataToExcel(combinedData, outputPath);

            System.out.println("Data from all files has been combined and stored in '" + outputPath + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void forwardDataToDatabase(List<String> data) {
        for (String entry : data) {
            YourEntity entity = new YourEntity();
            entity.setContent(entry);
            yourEntityRepository.save(entity);
        }
    }
    
    private List<List<String>> readAllExcelFiles(String folderPath) throws IOException {
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

    private List<String> readExcelFile(File file) throws IOException {
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

    private List<String> combineData(List<List<String>> allData) {
        List<String> combinedData = new ArrayList<>();
        for (List<String> data : allData) {
            combinedData.addAll(data);
        }
        return combinedData;
    }

    private void writeCombinedDataToExcel(List<String> data, String outputPath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            Sheet sheet = workbook.createSheet("Combined Data");

            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(data.get(i));
            }

            workbook.write(fos);
        }
    }
}
