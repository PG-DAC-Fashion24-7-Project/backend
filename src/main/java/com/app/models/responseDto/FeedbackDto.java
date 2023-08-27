package com.app.models.responseDto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class FeedbackDto {
	private long feedbackId;
	private String comment;
	private Date commentDate;
	private int rating;
	private String username;
	
	public FeedbackDto() {
		super();
	}
	public FeedbackDto(long feedbackId, String comment, Date commentDate, int rating, String username) {
		super();
		this.feedbackId = feedbackId;
		this.comment = comment;
		this.commentDate = commentDate;
		this.rating = rating;
		this.username = username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "FeedbackDto [feedbackId=" + feedbackId + ", comment=" + comment + ", commentDate=" + commentDate
				+ ", rating=" + rating + ", username=" + username + "]";
	}

}
