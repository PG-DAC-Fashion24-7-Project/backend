package com.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="product")
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	@Id
	private int id;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="productPrice")
	private double productPrice;
	
	@Column(name="productAddedDate")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date productAddedDate;

	@Column(name = "imageUrl")
	private String imageUrl;

	@ManyToOne // we can write this field in toString
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ProductSize> productSizeList;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)	//don't write this field in toString else it will give stackOverflow exception 
	private List<OrderItem> orderItemList;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)//don't write this field in toString else it will give stackOverflow exception
	private List<UserProductMeta> userProductMetaList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)//don't write this field in toString else it will give stackOverflow exception
	private List<Feedback> feedbackList;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)//don't write this field in toString else it will give stackOverflow exception
	private List<CartItem> cartItemList;
	
	
	public Product() {
		super();
	}

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, String productName, String productDescription, double productPrice, Date productAddedDate,
			String imageUrl) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productAddedDate = productAddedDate;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductAddedDate() {
		return productAddedDate;
	}

	public void setProductAddedDate(Date productAddedDate) {
		this.productAddedDate = productAddedDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductSize> getProductSizeList() {
		return productSizeList;
	}

	public void setProductSizeList(List<ProductSize> productSizeList) {
		this.productSizeList = productSizeList;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public List<UserProductMeta> getUserProductMetaList() {
		return userProductMetaList;
	}

	public void setUserProductMetaList(List<UserProductMeta> userProductMetaList) {
		this.userProductMetaList = userProductMetaList;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	
	
}
