package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductReository;
import com.example.demo.dao.Product_DetailsReository;
import com.example.demo.dto.Product;
import com.example.demo.dto.ProductDetails;


@Service
public class ProductService {

	@Autowired
	private ProductReository productReository;
	
	/*
	 * @Autowired private Product_DetailsReository product_DetailsReository;
	 * 
	 * public List<Product> getAllProduct() {
	 * System.out.println("inside ProductService.getAllProduct");
	 * System.out.println("inside productService.getAllProducts() "); List<Product>
	 * prodlist=productReository.findAll();
	 * 
	 * return prodlist; }
	 * 
	 * public List<ProductDetails> getAllProductdtails() {
	 * System.out.println("inside ProductService.getAllProduct");
	 * System.out.println("inside productService.getAllProducts() ");
	 * List<ProductDetails> prodetails=product_DetailsReository.findAll();
	 * 
	 * return prodetails;
	 * 
	 * }
	 */

	
	

	    public Product createProduct(Product product) {
	    	System.out.println("inside createProduct");
	    	Product pro=productReository.save(product);
	        return pro;
	    }

	    public List<Product> getActiveProducts() {
	    	System.out.println("inside getActiveProducts");
	       List<Product> active  =productReository.findByStatus("active");
	       
	       
	         return active;
		}
	
}

