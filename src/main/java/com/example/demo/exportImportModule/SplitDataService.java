
  package com.example.demo.exportImportModule;
  
  import java.io.FileInputStream;
  import java.io.IOException; 
  import java.nio.file.Files;
  import java.nio.file.Paths;
  import org.apache.poi.ss.usermodel.Workbook; 
  import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  import com.example.demo.service.ProductService;
  
  @Service 
  public class SplitDataService {
  
  @Autowired 
  ProductService productService;
  
  public static void deleteSpecificFile(String folderPath, String fileName) {
  
 /* try { // Check if the specific file exists Path filePath =
  Paths.get(folderPath, fileName); 
  boolean isFileExists = Files.exists(filePath);
  
  if (isFileExists) { // Delete the specific file Files.delete(filePath);
  System.out.println("Deleted file: " + filePath.toString()); } else {
  System.out.println("The specific file '" + fileName + "' does not exist."); }
  
  } catch (IOException e) { e.printStackTrace(); } }
  
  public void Splitter() { String inputFilePath = "src/data/product.xlsx"; try
  (FileInputStream fileInputStream = new FileInputStream(inputFilePath);
  Workbook workbook = new XSSFWorkbook(fileInputStream)) {
  
  // Assuming that your data is present in the first sheet Sheet sheet =
  workbook.getSheetAt(0);
  
  // Iterate through rows for (int rowIndex = 0; rowIndex <=
  sheet.getLastRowNum(); rowIndex++) { Row row = sheet.getRow(rowIndex);
  
  // Create a new workbook for each row Workbook newWorkbook = new
  XSSFWorkbook(); Sheet newSheet = newWorkbook.createSheet("Sheet1");
  
  // Copy the row to the new sheet Row newRow = newSheet.createRow(0); for (int
  cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) { Cell cell =
  row.getCell(cellIndex); Cell newCell = newRow.createCell(cellIndex);
  
  if (cell != null) { switch (cell.getCellType()) { case STRING:
  newCell.setCellValue(cell.getStringCellValue()); break; case NUMERIC:
  newCell.setCellValue(cell.getNumericCellValue()); break; } } }
  
  // Save the new workbook String outputFilePath = "src/data/" + rowIndex +
  ".xlsx"; try (FileOutputStream fileOutputStream = new
  FileOutputStream(outputFilePath)) { newWorkbook.write(fileOutputStream); }
  catch (IOException e) { e.printStackTrace(); }
  
  System.out.println("Excel file for row " + rowIndex + " created: " +
  outputFilePath); }
  
  } catch (IOException e) { e.printStackTrace(); }
  
  }*/
  
  
  //}
 