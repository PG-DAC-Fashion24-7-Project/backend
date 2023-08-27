package com.app.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Category;
import com.app.entities.Feedback;
import com.app.entities.Product;
import com.app.entities.ProductSize;
import com.app.exception.customexceptions.CategoryNotFoundException;
import com.app.models.responseDto.DtoEntityConverter;
import com.app.models.responseDto.FeedbackDto;
import com.app.models.responseDto.NewFeedbackDtoForCommentOnProduct;
import com.app.models.responseDto.ProductDto;
import com.app.repository.ICategoryRepository;
import com.app.repository.IFeedbackRepository;
import com.app.repository.IProductRepository;

@Transactional
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productDao;

	@Autowired
	private IFeedbackRepository feedbackRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private DtoEntityConverter converter;

	// ****************************** -GET/
	// ****************************************************

	public List<ProductDto> findAllProduct() { // find all product
		List<Product> productList = productDao.findAll();
		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
	}

	public ProductDto findProductById(int id) { // get product details by id
		Product product = productDao.findById(id);
		return converter.toProductDto(product);
	}

	public List<ProductDto> findProductByCategoryName(String categoryName) { // find product By categoryId
		int categoryId = categoryRepository.findCategoryIdByCategoryName(categoryName);
		Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category Id not found.."));
		List<Product> productList = category.getProductList();
		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
	}

	public List<ProductDto> findProductByProductPriceGreaterThan(double productPrice) { // find all product by price
																						// greater than specified
		List<Product> productList = productDao.findByProductPriceGreaterThanOrderByProductPriceAsc(productPrice);
		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
	}

	public List<ProductDto> findProductByProductPriceLessThan(double productPrice) { // find all product by price less
																						// than specified
		List<Product> productList = productDao.findByProductPriceLessThanOrderByProductPriceAsc(productPrice);
		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
	}

//	public List<ProductDto> findProductByProductSize(String productSize) { // find all product by price less than
//																			// specified
//		List<Product> productList = productDao.findBySizeContaining(productSize);
//		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
//	}

	public List<ProductDto> findByProductDescriptionContaining(String tag) { // find product by tag
		List<Product> productList = productDao.findByProductDescriptionContainingIgnoreCase(tag);
		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
	}

//	public int getTotalProductQuantity() { // get total product quantity
//		return productDao.getTotalQuantity();
//	}

	public List<ProductDto> findByNewlyAddedProducts() { // find by latest product
		List<Product> productList = productDao.findByNewlyAddedProducts();
		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
	}

	public List<ProductDto> findByAllProductWithDiscount(int discount) { // find All Product with discount by final
																			// discounted price
		List<Product> productList = productDao.findByAllProductWithDiscount(discount);
		return productList.stream().map(product -> converter.toProductDto(product)).collect(Collectors.toList());
	}
	
	@Override
	public List<String> findAllSizeNamesByProductId(int id){
		Product product = productDao.findById(id);
		List<ProductSize> productSizeList = product.getProductSizeList();
		return productSizeList.stream().filter((s) -> s.getProduct().equals(product)).map((p) -> p.getSizeName()).collect(Collectors.toList());
	}

//****************************************************************

	public List<FeedbackDto> findAllFeedbackByProductId(int id) {
		List<Feedback> feedbackList = productDao.findById(id).getFeedbackList();
		return feedbackList.stream().map(feedback -> converter.toFeedbackDto(feedback)).collect(Collectors.toList());
	}

	public List<Object[]> findAllCommentByProductId(int id) {
		return feedbackRepository.findAllCommentByProductId(id);
	}

	public List<Object[]> findAllRatingByProductId(int id) {
		return feedbackRepository.findAllRatingByProductId(id);
	}

	public double getAvgRatingByProductId(int id) {
		return productDao.getAvgRatingByProductId(id);
	}

	public int getSumOfRatingByProductId(int id) {
		return productDao.getSumOfRatingByProductId(id);
	}

	public Map<String, Object> addProductFeedbackByProductId(int productId, NewFeedbackDtoForCommentOnProduct newFeedbackDto) {
		newFeedbackDto.setProductId(productId);
		Feedback feedback = converter.toFeedbackEntity(newFeedbackDto);
		feedback = feedbackRepository.save(feedback);
		return Collections.singletonMap("insertedId", feedback.getFeedbackId());
	}
	
//	public Map<String, Object> addBlogComment(int blogId, BlogCommentDTO commentDto) {
//		commentDto.setBlogId(blogId);
//		BlogComment comment = converter.toCommentEntity(commentDto);
//		comment = commentDao.save(comment);
//		return Collections.singletonMap("insertedId", comment.getId());
//	}
	
//	public Map<String, Object> addProductFeedback(NewFeedbackDtoForCommentOnProduct newFeedbackDto) {
//		Feedback feedback = converter.toFeedbackEntity(newFeedbackDto);
//		feedback = feedbackRepository.save(feedback);
//		return Collections.singletonMap("insertedId", feedback.getFeedbackId());
//	}
	
	

	// ****************************** -GET/
	// ****************************************************

}
