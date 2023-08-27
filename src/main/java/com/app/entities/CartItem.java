package com.app.entities;

import javax.persistence.*;

//import lombok.*;
//import lombok.experimental.Accessors;

//@Getter
//@Setter
//@Accessors(chain=true)
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "cartItem")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartItemId")
	private Long cartItemId;
	@Column(name = "unitQuantity")
	private int unitQuantity;
	@Column(name = "unitPrice")
	private double unitPrice;
	@Column(name = "totalPrice")
	private double totalPrice;
	@Column(name = "sizeName")
	private String sizeName;
	

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	public CartItem(Long cartItemId, int unitQuantity, double unitPrice, double totalPrice) {
		super();
		this.cartItemId = cartItemId;
		this.unitQuantity = unitQuantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	
	public CartItem(Long cartItemId, int unitQuantity, double unitPrice, double totalPrice, String sizeName) {
		super();
		this.cartItemId = cartItemId;
		this.unitQuantity = unitQuantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.sizeName = sizeName;
	}


	public CartItem() {
		super();
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	
	
}
