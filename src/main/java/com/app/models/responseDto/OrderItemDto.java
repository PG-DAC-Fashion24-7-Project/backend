package com.app.models.responseDto;

import javax.persistence.Column;

public class OrderItemDto {
	private long orderItemId;
	private double productPrice;
	private int productQuantity;
	private int productId;
	private String productName;
	private String imageUrl;
	
	public OrderItemDto() {
		super();
	}

	public OrderItemDto(long orderItemId, double productPrice, int productQuantity, int productId, String productName, String imageUrl) {
		super();
		this.orderItemId = orderItemId;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
	}

	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "OrderItemDto [orderItemId=" + orderItemId + ", productPrice=" + productPrice + ", productQuantity="
				+ productQuantity + ", productId=" + productId + ", productName=" + productName + ", imageUrl="
				+ imageUrl + "]";
	}
	
	
	
}
