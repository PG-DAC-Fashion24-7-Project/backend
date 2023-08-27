package com.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

//import lombok.*;
//import lombok.experimental.Accessors;

//@Getter
//@Setter
//@Accessors(chain=true)
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	private Long cartId;
	@Column(name = "totalQuantity")
	private int totalQuantity;
	@Column(name = "totalCartPrice")
	private double totalCartPrice;
	@Column(name = "cartStatus")
	private String cartStatus;
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationTime")
    private Date creationTime;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<CartItem> cartItemList;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Payment> paymentList;


	public Cart(Long cartId, int totalQuantity, double totalCartPrice, String cartStatus, Date creationTime) {
		super();
		this.cartId = cartId;
		this.totalQuantity = totalQuantity;
		this.totalCartPrice = totalCartPrice;
		this.cartStatus = cartStatus;
		this.creationTime = creationTime;
	}

	public Cart() {
		super();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	
	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalQuantity=" + totalQuantity + ", totalCartPrice=" + totalCartPrice
				+ ", cartStatus=" + cartStatus + ", creationTime=" + creationTime + "]";
	}


	


//	@OneToMany(mappedBy = "cart")
//	private List<Size> sizeList;

	

}
