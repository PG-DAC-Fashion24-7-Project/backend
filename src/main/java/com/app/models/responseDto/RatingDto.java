package com.app.models.responseDto;

public class RatingDto {
	private int rating;

	public RatingDto(int rating) {
		super();
		this.rating = rating;
	}

	public RatingDto() {
		super();
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "RatingDto [rating=" + rating + "]";
	}
	
	
}
