package com.app.services;

import java.util.List;

import com.app.entities.Cart;
import com.app.entities.CartItem;
import com.app.entities.Product;
import com.app.exception.customexceptions.CartNotFoundException;
import com.app.models.responseDto.CartDto;
import com.app.models.responseDto.CartItemDto;
import com.app.models.responseDto.CartView;

public interface ICartService {
	CartDto getCartById(Long cartId);
	List<CartItemDto> getAllCartItemsByCartId(Long cartId);
	List<CartItemDto> getCartItemsByUserId(Long userId);
//	void addToCart();
	boolean addToCart(Long userId, int productId, int unitQuantity, String sizeName);
	CartView getCartView(Long userId);
}
