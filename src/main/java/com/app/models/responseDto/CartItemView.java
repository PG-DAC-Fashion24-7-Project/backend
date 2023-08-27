package com.app.models.responseDto;

public class CartItemView {
	private int productId;
	private String productName;
	private String sizeName;
	private int unitQuantity;
	private double unitPrice;
	private double totalPrice;
	private String imageUrl;
	
	public CartItemView() {
		super();
	}

	public CartItemView(int productId, String productName, String sizeName, int unitQuantity, double unitPrice,
			double totalPrice, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.sizeName = sizeName;
		this.unitQuantity = unitQuantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.imageUrl = imageUrl;
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

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public int getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(int unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	
}
