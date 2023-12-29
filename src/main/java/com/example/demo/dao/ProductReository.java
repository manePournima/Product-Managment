package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Product;

@Repository
public interface ProductReository extends JpaRepository <Product, Integer> {
	List<Product> findByStatus(String status);

}
