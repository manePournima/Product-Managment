package com.example.demo.exportImportModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

/*import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.dto.ProductDetails;
import com.example.demo.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;*/

@RestController
@RequestMapping("/api/products")
public class DownloadController {
	
/*
    @Autowired
    private ProductService productService;*/
    
    @Autowired
    private DownloadService downloadService;
  

   /* @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = downloadService.getAllProduct();
        return ResponseEntity.ok(products);
    }*/

	/*
	 * @GetMapping("/details") public ResponseEntity<List<ProductDetails>>
	 * getAllProductDetails() { List<ProductDetails> productDetails =
	 * productService.getAllProductdetails(); return
	 * ResponseEntity.ok(productDetails); }
	 * 
	 * @GetMapping("/byStatus") public ResponseEntity<List<Product>>
	 * getProductsByStatus(@RequestParam String status) { List<Product> products =
	 * productService.getActiveProducts(status); return ResponseEntity.ok(products);
	 * }
	 */
    @GetMapping("/downloadExcel")
    public ResponseEntity<byte[]> downloadExcel (HttpServletResponse response)
    {
    	System.out.println("inside downloadService downloadExcel");
    ResponseEntity<byte[]>responseEntity= downloadService.downloadExcel(response);
    	
    	return responseEntity;
    }
    
  
    }
