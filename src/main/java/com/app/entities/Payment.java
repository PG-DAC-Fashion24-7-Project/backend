package com.app.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

//import lombok.*;
//import lombok.experimental.Accessors;
//
//@Getter
//@Setter
//@Accessors(chain=true)
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId")
	private int paymentId;
	@Column(name = "totalAmount")
	private double totalAmount;
	@Column(name = "paymentMode")
	private String paymentMode;

	@Column(name = "paymentDate")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;

	@Column(name = "paymentStatus")
	private String paymentStatus;

	@OneToOne
	@JoinColumn(name = "orderId")
	private OrderDetail orderDetail;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	public Payment() {
		super();
	}

	public Payment(int paymentId, double totalAmount, String paymentMode, Date paymentDate, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.totalAmount = totalAmount;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
}
