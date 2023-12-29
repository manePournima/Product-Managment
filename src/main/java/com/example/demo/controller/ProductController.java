package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController() {
		System.out.println("inside ProductController const");
	}

	@GetMapping("/healthcheck")
	public String heathcheck() {
		return "Product Service UP";
	}

	@GetMapping("/getAllProduct/")
	public List<Product> getAllActiveProduct() {
		System.out.println("inside ProductController.getAllActiveProduct");

		List<Product> prodlist = productService.getAllProduct();
		System.out.println(prodlist);
		return prodlist;

	}

	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		System.out.println("inside ProductController. createProduct ");
		Product product1 = productService.createProduct(product);
		return product1;
	}

	@GetMapping("/active")
	public List<Product> getactivestatus(String status) {
		System.out.println("inside getactive Status");
		List<Product> pa = productService.getActiveProducts(status);
		return pa;
	}

	/*
	 * @GetMapping("/findById") public Product findByid() {
	 * System.out.println("inside ProductController.findBYId");
	 * productService.ProductById(); return null; }
	 */

}
