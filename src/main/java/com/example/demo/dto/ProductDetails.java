package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductDetails_projectManagment")
public class ProductDetails {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private double price;

	@Column
	private String manufacturer;

	@Column
	private String manufacturing_Date;

	
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", price=" + price + ", manufacturer=" + manufacturer
				+ ", manufacturing_Date=" + manufacturing_Date + "]";
	}
	
	

	public ProductDetails(int id, String name, double price, String manufacturer, String manufacturing_Date,
			Product product) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
		this.manufacturing_Date = manufacturing_Date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturing_Date() {
		return manufacturing_Date;
	}

	public void setManufacturing_Date(String manufacturing_Date) {
		this.manufacturing_Date = manufacturing_Date;
	}



	
}
