package com.app.services;

import java.util.List;
import java.util.Map;

import com.app.entities.Feedback;
import com.app.entities.Product;
import com.app.models.responseDto.FeedbackDto;
import com.app.models.responseDto.NewFeedbackDtoForCommentOnProduct;
import com.app.models.responseDto.ProductDto;

public interface IProductService {
	
		List<ProductDto> findAllProduct();
		ProductDto findProductById(int id);
		List<ProductDto> findProductByCategoryName(String categoryName);
		List<ProductDto> findProductByProductPriceGreaterThan(double productPrice);
		List<ProductDto> findProductByProductPriceLessThan(double productPrice);
//		List<ProductDto> findProductByProductSize(String size);
		List<ProductDto> findByProductDescriptionContaining(String tag);
//		int getTotalProductQuantity();
		List<ProductDto> findByNewlyAddedProducts();
		List<ProductDto> findByAllProductWithDiscount(int discount);
		
		List<String> findAllSizeNamesByProductId(int id);
	
	List<FeedbackDto> findAllFeedbackByProductId(int id);
	List<Object[]> findAllCommentByProductId(int id);
	List<Object[]> findAllRatingByProductId(int id);
	double getAvgRatingByProductId(int id);
	int getSumOfRatingByProductId(int id);
	
//	Map<String, Object> addProductFeedback(NewFeedbackDtoForCommentOnProduct newFeedbackDto);
	Map<String, Object> addProductFeedbackByProductId(int productId, NewFeedbackDtoForCommentOnProduct newFeedbackDto);
	
	
}
