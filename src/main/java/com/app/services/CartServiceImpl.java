package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Cart;
import com.app.entities.CartItem;
import com.app.entities.Product;
import com.app.entities.User;
import com.app.exception.customexceptions.CartNotFoundException;
import com.app.exception.customexceptions.UserNotFoundException;
import com.app.models.responseDto.CartDto;
import com.app.models.responseDto.CartItemDto;
import com.app.models.responseDto.CartItemView;
import com.app.models.responseDto.CartView;
import com.app.repository.ICartItemRepository;
import com.app.repository.ICartRepository;
import com.app.repository.IProductRepository;
import com.app.repository.IUserRepository;

@Transactional
@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private ICartRepository cartRepository;
	@Autowired
	private ICartItemRepository cartItemRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ModelMapper mapper;
//	private List<CartItem> carts = new ArrayList<>();

	@Override
	public CartDto getCartById(Long cartId) {
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart Not found"));
		CartDto cartdto = mapper.map(cart, CartDto.class);
		return cartdto;
	}

	@Override
	public List<CartItemDto> getAllCartItemsByCartId(Long cartId) {
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart not found"));
		List<CartItem> cartItemList = cart.getCartItemList();
		List<CartItemDto> newList = new ArrayList<CartItemDto>();
		cartItemList.forEach((s) -> newList.add(mapper.map(s, CartItemDto.class)));
		return newList;
	}

	@Override
	public List<CartItemDto> getCartItemsByUserId(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		List<CartItem> cartItemList = user.getCart().getCartItemList();
		List<CartItemDto> newList = new ArrayList<CartItemDto>();
		cartItemList.forEach((s) -> newList.add(mapper.map(s, CartItemDto.class)));
		return newList;
	    
	}
	
	public Cart getCartByUserId(Long userId){
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		return user.getCart();
	}

	@Override
	public boolean addToCart(Long userId, int productId, int unitQuantity, String sizeName) {
		 // Retrieve or create a cart for the user
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		Product product = productRepository.findById(productId);
        Cart cart = user.getCart();
        
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }
        
        CartItem existingCartItem = getCartItemByProductId(cart, product, user, sizeName);
        if (existingCartItem != null) {
            // If the product exists, update the quantity
        	existingCartItem.setUnitQuantity(existingCartItem.getUnitQuantity() + unitQuantity);
        	existingCartItem.setTotalPrice(existingCartItem.getUnitQuantity() * existingCartItem.getUnitPrice());
        } else {
        	// If the product is not in the cart, create a new cart item
        	CartItem newCartItem = new CartItem();
        	newCartItem.setProduct(product);
        	newCartItem.setUnitQuantity(unitQuantity);
        	newCartItem.setUnitPrice(product.getProductPrice());
        	newCartItem.setTotalPrice(unitQuantity * product.getProductPrice());
        	newCartItem.setSizeName(sizeName);
        	newCartItem.setCart(cart);
 
        	cart.getCartItemList().add(newCartItem);
        }
        
        //update cart's total price and total quantity
        double totalCartPrice = cart.getCartItemList().stream().mapToDouble((s) -> s.getTotalPrice()).sum();
        int totalQuantity = cart.getCartItemList().stream().mapToInt((s) -> s.getUnitQuantity()).sum();
        cart.setTotalCartPrice(totalCartPrice);
        cart.setTotalQuantity(totalQuantity);
        cartRepository.save(cart);
        return true;
        
	}
	
	public CartItem getCartItemByProductId(Cart cart, Product product, User user, String sizeName) {
		List<CartItem> cartItemList = cart.getCartItemList();
		return cartItemList.stream().filter((s) -> s.getProduct().equals(product)).filter((p) -> p.getSizeName().equalsIgnoreCase(sizeName)).findAny().orElse(null);
	}

	@Override
	public CartView getCartView(Long userId) {
		
		CartView cartView = new CartView();
        List<CartItemView> cartItemViews = new ArrayList<>();
        Cart cart = getCartByUserId(userId);
        List<CartItem> cartItemsList = getCartByUserId(userId).getCartItemList();
        
        for (CartItem cartItem : cartItemsList) {
            CartItemView cartItemView = new CartItemView();
            cartItemView.setProductId(cartItem.getProduct().getId());
            cartItemView.setSizeName(cartItem.getSizeName());
            cartItemView.setUnitQuantity(cartItem.getUnitQuantity());
            // Fetch product details (name, price) based on cart item's productId
            // Set product name and calculate total price
//            Product product = productService.getProductById(cartItem.getProductId());
            Product product = productRepository.findById(cartItem.getProduct().getId());
            if (product != null) {
                cartItemView.setProductName(product.getProductName());
                cartItemView.setImageUrl(product.getImageUrl());
                cartItemView.setUnitPrice(product.getProductPrice());
                cartItemView.setTotalPrice(product.getProductPrice() * cartItem.getUnitQuantity());
            }

            cartItemViews.add(cartItemView);
        }

        double totalCartPrice = cartItemsList.stream().mapToDouble((s) -> s.getTotalPrice()).sum();// From previous example
        cartView.setCartItems(cartItemViews);
        cartView.setCartId(cart.getCartId());
        cartView.setCartStatus(cart.getCartStatus());
        cartView.setCreationTime(cart.getCreationTime());
        cartView.setTotalQuantity(cart.getTotalQuantity());
        cartView.setTotalCartPrice(totalCartPrice);

        return cartView;
	}
	
	
	
	
	
}
