package com.app.models.responseDto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

public class ProductDto {
	private int id;
	private String productName;
	private String productDescription;
	private double productPrice;
	private String imageUrl;
	
	public ProductDto() {
		super();
	}

	public ProductDto(int id, String productName, String productDescription, double productPrice, String imageUrl) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.imageUrl = imageUrl;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


}

