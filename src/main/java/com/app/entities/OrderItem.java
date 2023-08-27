package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderItemId")
	private long orderItemId;
	@Column(name = "productPrice")
	private double productPrice;
	@Column(name = "productQuantity")
	private int productQuantity;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")   //foreign key column name
	private OrderDetail orderdetail;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private Product product;
	
	public OrderItem() {
	}
	
	public OrderItem(long orderItemId) {
		super();
		this.orderItemId = orderItemId;
	}

	public OrderItem(long orderItemId, double productPrice, int productQuantity, OrderDetail orderdetail,
			Product product) {
		super();
		this.orderItemId = orderItemId;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.orderdetail = orderdetail;
		this.product = product;
	}

	public OrderItem(long orderItemId, double productPrice, int productQuantity) {
		super();
		this.orderItemId = orderItemId;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
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

	public OrderDetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", productPrice=" + productPrice + ", productQuantity="
				+ productQuantity + "]";
	}


}
