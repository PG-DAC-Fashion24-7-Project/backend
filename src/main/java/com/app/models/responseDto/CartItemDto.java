package com.app.models.responseDto;

public class CartItemDto {
	private Long cartItemId;
	private int unitQuantity;
	private double unitPrice;
	private double totalPrice;
	private String sizeName;
	
	public CartItemDto() {
		super();
	}

	public CartItemDto(Long cartItemId, int unitQuantity, double unitPrice, double totalPrice, String sizeName) {
		super();
		this.cartItemId = cartItemId;
		this.unitQuantity = unitQuantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.sizeName = sizeName;
	}


	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
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

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	
	
	
}
