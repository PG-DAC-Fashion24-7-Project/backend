package com.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "orderdetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private long orderId;
	@Column(name = "orderNumber")
	private long orderNumber;
	@Column(name = "orderStatus")
	private String orderStatus;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "orderDate")
	private Date orderDate;
	@Column(name = "totalAmount")
	private double totalAmount;
	@Column(name = "numberOfOrderedProduct")
	private int numberOfOrderedProduct;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "orderdetail")
	private List<OrderItem> orderItemList;
	
	@OneToOne(mappedBy = "orderDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Payment payment;
	
	public OrderDetail() {
	}

	public OrderDetail(long orderId) {
		this.orderId = orderId;
	}

	public OrderDetail(long orderId, long orderNumber, String orderStatus, Date orderDate, double totalAmount,
			int numberOfOrderedProduct) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.numberOfOrderedProduct = numberOfOrderedProduct;
	}

	public OrderDetail(long orderId, long orderNumber, String orderStatus, Date orderDate, double totalAmount,
			int numberOfOrderedProduct, User user) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.numberOfOrderedProduct = numberOfOrderedProduct;
		this.user = user;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getNumberOfOrderedProduct() {
		return numberOfOrderedProduct;
	}

	public void setNumberOfOrderedProduct(int numberOfOrderedProduct) {
		this.numberOfOrderedProduct = numberOfOrderedProduct;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", numberOfOrderedProduct="
				+ numberOfOrderedProduct + "]";
	}


	
}