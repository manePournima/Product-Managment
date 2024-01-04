
package com.example.demo.dto;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_projectManagment")
public class Product {
	
	@Id
	@Column
	private int id;
	@Column
	private String pname;
	
	@Column
	private String status;
	
	
	
	@JoinColumn(name = "p_fk",referencedColumnName = "id")
	@OneToMany(targetEntity = ProductDetails.class ,cascade = CascadeType.ALL)
    private List<ProductDetails> details;
	
		
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getpname() {
		return pname;
	}
	public void setpname(String pname) {
		this.pname = pname;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public List<ProductDetails> getDetails() {
		return details;
	}
	public void setDetails(List<ProductDetails> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", status=" + status + ", details=" + details + "]";
	}
	
	
	
	

}
