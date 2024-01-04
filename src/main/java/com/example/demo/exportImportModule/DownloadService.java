package com.example.demo.exportImportModule;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;
import com.example.demo.dto.ProductDetails;
import com.example.demo.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class DownloadService {
	

    @Autowired
     ProductService productService;

	 public ResponseEntity<byte[]> downloadExcel(HttpServletResponse response) {
	    	
	        try {
	            List<Product> products = productService.getAllProduct();
	            List<ProductDetails> productDetails = productService.getAllProductdetails();

	            Workbook workbook = ExcelGenerator.createExcel(products, productDetails);

	            // Convert workbook to byte array
	            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	            workbook.write(byteArrayOutputStream);
	            byte[] excelBytes = byteArrayOutputStream.toByteArray();

	            // Set the file name and headers
	            HttpHeaders headers = new HttpHeaders();
	            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=product.xlsx");
	            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

	            SplitData sd=new SplitData();
	            sd.deleteSpecificFile("C:/Users/HP/Downloads/product.xlsx", "products.xlsx");
	            sd.Splitter();
	            
	            return ResponseEntity.ok().headers(headers).body(excelBytes);

	        } catch (IOException e) {
	            e.printStackTrace();
	           // return ResponseEntity.status(500).body("Error downloading Excel");
				/*
				 * ResponseEntity responseEntity =
				 * ResponseEntity.status(500).body("Error downloading Excel"); return
				 * responseEntity;
				 */
	            return null;
	            } 
	 }
	                
}

	
