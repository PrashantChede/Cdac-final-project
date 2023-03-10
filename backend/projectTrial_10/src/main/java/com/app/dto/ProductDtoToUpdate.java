package com.app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * Product Entity : id, name,price,desc,inStock +
private Category productCategory;

 */

public class ProductDtoToUpdate {
	
	private Long id;
	private String productName;
	
	private String latitude;
	
	private String longitude;
	private String description;
	
	private int inStock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public ProductDtoToUpdate(Long id, String productName, String latitude, String longitude, String description,
			int inStock) {
		super();
		this.id = id;
		this.productName = productName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "ProductDtoToUpdate [id=" + id + ", productName=" + productName + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", description=" + description + ", inStock=" + inStock + "]";
	}

	
	

	

	

		

	

	
	
}
