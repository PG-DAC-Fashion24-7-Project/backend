package com.app.models.responseDto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.app.entities.Feedback;
import com.app.entities.OrderDetail;
import com.app.entities.OrderItem;
import com.app.entities.Product;
import com.app.entities.User;

@Component
public class DtoEntityConverter {
	public OrderDetailDto toOrderDetailDto(OrderDetail entity) {
		OrderDetailDto dto = new OrderDetailDto();
		dto.setOrderId(entity.getOrderId());
		dto.setOrderNumber(entity.getOrderNumber());
		dto.setOrderStatus(entity.getOrderStatus());
		dto.setOrderDate(entity.getOrderDate());
		dto.setTotalAmount(entity.getTotalAmount());
		dto.setNumberOfOrderedProduct(entity.getNumberOfOrderedProduct());
		return dto;
	}
	
	public OrderItemDto toOrderItemDto(OrderItem entity) {
		OrderItemDto dto = new OrderItemDto();
		dto.setOrderItemId(entity.getOrderItemId());
		dto.setProductPrice(entity.getProductPrice());
		dto.setProductQuantity(entity.getProductQuantity());
		dto.setProductName(entity.getProduct().getProductName());
		dto.setImageUrl(entity.getProduct().getImageUrl());
		return dto;
	}
	
	public FeedbackDto toFeedbackDto(Feedback entity) {
		FeedbackDto dto = new FeedbackDto();
		dto.setFeedbackId(entity.getFeedbackId());
		dto.setComment(entity.getComment());
		dto.setCommentDate(entity.getCommentDate());
		dto.setRating(entity.getRating());
		dto.setUsername(entity.getUser().getUsername());
		return dto;
	}
	
	public FeedbackDto toRatingDto(Feedback entity) {
		FeedbackDto dto = new FeedbackDto();
		dto.setRating(entity.getRating());
		return dto;
	}
	
	public FeedbackDto toRatingDto(RatingDto rating) {
		FeedbackDto dto = new FeedbackDto();
		dto.setRating(rating.getRating());
		return dto;
	}
	
	public Feedback toFeedbackEntity(NewFeedbackDtoForCommentOnProduct newFeedbackDto) {
		if(newFeedbackDto == null)
			return null;
		Feedback entity = new Feedback();
		entity.setProduct(new Product(newFeedbackDto.getProductId()));
		entity.setUser(new User(newFeedbackDto.getUserId()));
		entity.setComment(newFeedbackDto.getComment());
		//entity.setCommentDate(new Date());
		entity.setRating(newFeedbackDto.getRating());
		return entity;
	}
	
//	public Feedback toFeedbackEntity(NewFeedbackDtoForCommentOnProduct newFeedbackDto) {
//		if(newFeedbackDto == null)
//			return null;
//		Feedback entity = new Feedback();
//		entity.setComment(newFeedbackDto.getComment());
//		return entity;
//	}
	
	public ProductDto toProductDto(Product entity) {
		ProductDto dto = new ProductDto();
		dto.setId(entity.getId());
		dto.setProductName(entity.getProductName());
		dto.setProductDescription(entity.getProductDescription());
		dto.setProductPrice(entity.getProductPrice());
		dto.setImageUrl(entity.getImageUrl());
		return dto;
	}
	
	
}
