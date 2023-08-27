package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.requestDto.AddToCartPayload;
import com.app.models.responseDto.CartView;
import com.app.services.ICartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class CartController {
	@Autowired
	private ICartService cartService;
	
	@GetMapping("/api/cart/{cartId}")
	public ResponseEntity<?> getCartByCartId(@PathVariable Long cartId){
//		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.getCartById(cartId));
		return Response.success(cartService.getCartById(cartId));
	}

	@GetMapping("/api/cartitems/{cartId}")
	public ResponseEntity<?> getCartItemsByCartId(@PathVariable Long cartId){
		return Response.success(cartService.getAllCartItemsByCartId(cartId));
	}
	
	@GetMapping("/api/user/cart/{userId}")
	public ResponseEntity<?> getCartItemsByUserId(@PathVariable Long userId){
		return Response.success(cartService.getCartItemsByUserId(userId));
	}
	
	@PostMapping("/api/cart/addtocart")
	public ResponseEntity<?> addToCartController(@RequestBody AddToCartPayload payload){
		Long userId = payload.getUserId();
		int productId = payload.getProductId();
		int unitQuantity = payload.getUnitQuantity();
		String sizeName = payload.getSizeName();
		if(cartService.addToCart(userId, productId, unitQuantity, sizeName)) 
			Response.error("Product did not get added in cart!!!");
		return Response.successMessage("Product added in cart successfully...");
	}
	
	@GetMapping("/api/cart/viewcart/{userId}")
	public ResponseEntity<?> viewCart(@PathVariable Long userId){
		CartView cartView = cartService.getCartView(userId);
		return Response.success(cartView);
	}
	
}
