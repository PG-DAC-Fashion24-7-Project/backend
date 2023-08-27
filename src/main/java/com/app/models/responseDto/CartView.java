package com.app.models.responseDto;

import java.util.Date;
import java.util.List;

public class CartView {
	private Long cartId;
	private int totalQuantity;
	private double totalCartPrice;
	private String cartStatus;
	private Date creationTime;
	private List<CartItemView> cartItems;
	
	public CartView() {
		super();
	}

	public CartView(Long cartId, int totalQuantity, double totalCartPrice, String cartStatus, Date creationTime) {
		super();
		this.cartId = cartId;
		this.totalQuantity = totalQuantity;
		this.totalCartPrice = totalCartPrice;
		this.cartStatus = cartStatus;
		this.creationTime = creationTime;
	}
	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalCartPrice() {
		return totalCartPrice;
	}

	public void setTotalCartPrice(double totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public List<CartItemView> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemView> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	
}
