package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Product;
import com.example.demo.dto.ProductDetails;

@Repository
public interface Product_DetailsReository extends JpaRepository<ProductDetails, Integer> {

}
