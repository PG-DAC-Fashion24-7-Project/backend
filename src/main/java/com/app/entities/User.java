package com.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "userMobileNumber")
    private Long userMobileNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registeredAt")
    private Date registeredAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastLogin")
    private Date lastLogin;

    @Column(name = "isEmailVerified")
    private boolean isEmailVerified;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Address> addressList;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Feedback> feedbackList;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Cart cart;

    public User() {
    }
    public User(User user) {
        this.userEmail = user.getUserEmail();
        this.userMobileNumber = user.getUserMobileNumber();
        this.role = user.getRole();
        this.isEmailVerified = user.isEmailVerified();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.gender = user.getGender();

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(Long userId) {
		super();
		this.userId = userId;
	}
	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(Long userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

    
}