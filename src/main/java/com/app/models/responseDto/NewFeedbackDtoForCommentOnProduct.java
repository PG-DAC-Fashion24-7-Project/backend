package com.app.models.responseDto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class NewFeedbackDtoForCommentOnProduct {
	private String comment;
	private Date commentDate;
	private int rating;
	private int productId;
	private long userId;
	
	public NewFeedbackDtoForCommentOnProduct() {
		super();
	}

	public NewFeedbackDtoForCommentOnProduct(String comment, Date commentDate, int rating, int productId, long userId) {
		super();
		this.comment = comment;
		this.commentDate = commentDate;
		this.rating = rating;
		this.productId = productId;
		this.userId = userId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "NewFeedbackDtoForCommentOnProduct [comment=" + comment + ", commentDate=" + commentDate + ", rating="
				+ rating + ", productId=" + productId + ", userId=" + userId + "]";
	}

	
	
}

//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//public class NewFeedbackDtoForCommentOnProduct {
//	private String comment;
//	private int productId;
//	
//	public NewFeedbackDtoForCommentOnProduct() {
//		super();
//	}
//
//	public NewFeedbackDtoForCommentOnProduct(String comment, int productId) {
//		super();
//		this.productId = productId;
//		this.comment = comment;
//	}
//
//	public String getComment() {
//		return comment;
//	}
//
//	public void setComment(String comment) {
//		this.comment = comment;
//	}
//
//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//
//	@Override
//	public String toString() {
//		return "NewFeedbackDtoForCommentOnProduct [comment=" + comment + ", productId=" + productId + "]";
//	}
//
//	
//	
//}
