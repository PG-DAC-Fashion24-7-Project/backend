package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Feedback;
import com.app.models.responseDto.FeedbackDto;
import com.app.models.responseDto.NewFeedbackDtoForCommentOnProduct;
import com.app.models.responseDto.ProductDto;
import com.app.services.IProductService;
@CrossOrigin("*")
@RequestMapping("")
@RestController
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("/api/public/product/allFeedback/{id}")
	public ResponseEntity<?> findAllFeedbackByProductId(@PathVariable("id") int productId){
		List<FeedbackDto> result = productService.findAllFeedbackByProductId(productId);
		if(result == null) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	@GetMapping("/api/public/product/allComment/{id}")
	public ResponseEntity<?> findAllCommentByProductId(@PathVariable("id") int productId){
		List<Object[]> result = productService.findAllCommentByProductId(productId);
		if(result == null) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	@GetMapping("/api/public/product/allRating/{id}")
	public ResponseEntity<?> findAllRatingByProductId(@PathVariable("id") int productId){
		List<Object[]> result = productService.findAllRatingByProductId(productId);
		if(result == null) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	@GetMapping("/api/public/product/avgRating/{id}")
	public ResponseEntity<?> findAvgRatingByProductId(@PathVariable("id") int productId){
		double result = productService.getAvgRatingByProductId(productId);
		return Response.success(result);
	}
	
	@GetMapping("/api/public/product/sumOfRating/{id}")
	public ResponseEntity<?> findSumOfRatingByProductId(@PathVariable("id") int productId){
		int result = productService.getSumOfRatingByProductId(productId);
		return Response.success(result);
	}

	@PostMapping("user/product/addFeedback/{id}")
	public ResponseEntity<?> saveFeedback(@PathVariable("id") int productId, @RequestBody NewFeedbackDtoForCommentOnProduct feedback){
		Map<String, Object> result = productService.addProductFeedbackByProductId(productId, feedback);
		return Response.success(result);
	}
	
//	@PostMapping("/comment/{id}")
//	public ResponseEntity<?> saveComment(@PathVariable("id") int blogId, @RequestBody BlogCommentDTO comment) {
//		Map<String, Object> result = blogService.addBlogComment(blogId, comment);
//		return Response.success(result);
//	}
	
//	@PostMapping("user/product/addFeedback")
//	public ResponseEntity<?> saveFeedback(@RequestBody NewFeedbackDtoForCommentOnProduct feedback){
//		Map<String, Object> result = productService.addProductFeedback(feedback);
//		return Response.success(result);
//	}
	

		@GetMapping("/api/public/product/user/allProduct") // get all product
		public ResponseEntity<?> findAllProduct() {
			List<ProductDto> result = new ArrayList<>();
			result = productService.findAllProduct();
			return Response.success(result);
		}

		@GetMapping("/api/public/product/user/productDetails/{id}") // get product details by id
		public ResponseEntity<?> findProductById(@PathVariable("id") int id) {
			ProductDto result = productService.findProductById(id);
			return Response.success(result);
		}

		@GetMapping("/api/public/product/user/productByCategory/{categoryName}") // get all product by category name
		public ResponseEntity<?> findProductByCategoryId(@PathVariable("categoryName") String categoryName) {
			List<ProductDto> result = new ArrayList<>();
			result = productService.findProductByCategoryName(categoryName);
			return Response.success(result);
		}

		@GetMapping("/api/public/product/user/productByPriceGreaterThan/{productPrice}") // get Product By Product Price GreaterThan
		public ResponseEntity<?> findProductByProductPriceGreaterThan(@PathVariable("productPrice") double productPrice) {
			List<ProductDto> result = new ArrayList<>();
			result = productService.findProductByProductPriceGreaterThan(productPrice);
			return Response.success(result);
		}

		@GetMapping("/api/public/product/user/productByPriceLessThan/{productPrice}") // get Product By Product Price LessThan
		public ResponseEntity<?> findProductByProductPriceLessThan(@PathVariable("productPrice") double productPrice) {
			List<ProductDto> result = new ArrayList<>();
			result = productService.findProductByProductPriceLessThan(productPrice);
			return Response.success(result);
		}

//		@GetMapping("/api/public/product/user/productBySize/{productSize}") // get Product By Product size
//		public ResponseEntity<?> findProductByProductSize(@PathVariable("productSize") String productSize) {
//			List<ProductDto> result = new ArrayList<>();
//			result = productService.findProductByProductSize(productSize);
//			return Response.success(result);
//		}

		@GetMapping("/api/public/product/user/productByTag/{tag}") // find product by tag
		public ResponseEntity<?> findByProductDescriptionContaining(@PathVariable("tag") String tag) {
			List<ProductDto> result = new ArrayList<>();
			result = productService.findByProductDescriptionContaining(tag);
			return Response.success(result);
		}

		@GetMapping("/api/public/product/user/newProduct") // find by latest product
		public ResponseEntity<?> findByNewlyAddedProducts() {
			List<ProductDto> result = new ArrayList<>();
			result = productService.findByNewlyAddedProducts();
			return Response.success(result);
		}

		@GetMapping("/api/public/product/user/allPoductsWithDiscount/{discount}") // find All Product with discount by final discounted price
		public ResponseEntity<?> findByAllProductWithDiscount(@PathVariable("discount") int discount) {
			List<ProductDto> result = new ArrayList<>();
			result = productService.findByAllProductWithDiscount(discount);
			return Response.success(result);
		}
		
		@GetMapping("/api/public/product/user/allAvailableSizesOfProduct/{id}")
		public ResponseEntity<?> findAllAvailableSizesByProductId(@PathVariable int id){
			List<String> sizeNameList = productService.findAllSizeNamesByProductId(id);
			return Response.success(sizeNameList);
		}
}
