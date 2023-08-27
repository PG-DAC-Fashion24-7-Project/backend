package com.app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long feedbackId;
	@Column
	private String comment;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date commentDate;
	@Column
	private int rating;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	public Feedback() {
	}

	public Feedback(long feedbackId, String comment, Date commentDate, int rating) {
		super();
		this.feedbackId = feedbackId;
		this.comment = comment;
		this.commentDate = commentDate;
		this.rating = rating;
	}


	public Feedback(long feedbackId, String comment, Date commentDate, int rating, User user, Product product) {
		super();
		this.feedbackId = feedbackId;
		this.comment = comment;
		this.commentDate = commentDate;
		this.rating = rating;
		this.user = user;
		this.product = product;
	}


	public Feedback(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", comment=" + comment + ", commentDate=" + commentDate
				+ ", rating=" + rating + ", user=" + user + "]";
	}
	
}
