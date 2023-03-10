package com.app.pojos;

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
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	@Column(name = "product_name", length = 30, unique = true)
	private String productName;
	@Column(length = 20)
	private String latitude;
	@Column(length = 20)
	private String longitude;
	private String description;
	@Column(name = "in_stock")
	private int inStock;
//	// many to one Product *-----> 1Category
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category productCategory;
	// Product 1----->1 CartItem

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, String description, int inStock, String latitude, String longitude) {
		super();
		this.productName = productName;

		this.description = description;
		this.inStock = inStock;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int isInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
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

	public int getInStock() {
		return inStock;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product ID " + getId() + " [productName=" + productName + ", description=" + description + ", inStock="
				+ inStock + "latitude=" + latitude + "longitude=" + longitude + "]";
	}

}
