
 package com.example.demo.exportImportModule;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.example.demo.dto.Product;
import com.example.demo.dto.ProductDetails;

import java.util.List;

public class ExcelGenerator {

    public static Workbook createExcel(List<Product> products, List<ProductDetails> productDetails) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Product Data");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Product ID");
        headerRow.createCell(1).setCellValue("Product Name");
        headerRow.createCell(2).setCellValue("Product Status");

        Row detailsHeaderRow = sheet.createRow(1);
        detailsHeaderRow.createCell(0).setCellValue("Product Details ID");
        detailsHeaderRow.createCell(1).setCellValue("Details Name");
        detailsHeaderRow.createCell(2).setCellValue("Details Price");
        detailsHeaderRow.createCell(3).setCellValue("Details Manufacturer");
        detailsHeaderRow.createCell(4).setCellValue("Details Manufacturing Date");

        int rowNum = 2;
        for (Product product : products) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(product.getId());
            row.createCell(1).setCellValue(product.getpname());
            row.createCell(2).setCellValue(product.getStatus());

            for (ProductDetails details : product.getDetails()) {
                Row detailsRow = sheet.createRow(rowNum++);
                detailsRow.createCell(0).setCellValue(details.getId());
                detailsRow.createCell(1).setCellValue(details.getName());
                detailsRow.createCell(2).setCellValue(details.getPrice());
                detailsRow.createCell(3).setCellValue(details.getManufacturer());
                detailsRow.createCell(4).setCellValue(details.getManufacturing_Date());
            }
        }

        return workbook;
    }
}
