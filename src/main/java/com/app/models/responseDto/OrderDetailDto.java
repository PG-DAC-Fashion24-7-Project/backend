package com.app.models.responseDto;

import java.util.Date;

public class OrderDetailDto {
	private long orderId;
	private long orderNumber;
	private String orderStatus;
	private Date orderDate;
	private double totalAmount;
	private int numberOfOrderedProduct;
	
	public OrderDetailDto() {
		super();
	}

	public OrderDetailDto(long orderId, long orderNumber, String orderStatus, Date orderDate, double totalAmount,
			int numberOfOrderedProduct) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.numberOfOrderedProduct = numberOfOrderedProduct;
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

	@Override
	public String toString() {
		return "OrderDetailDto [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", numberOfOrderedProduct="
				+ numberOfOrderedProduct + "]";
	}
	
	
}
