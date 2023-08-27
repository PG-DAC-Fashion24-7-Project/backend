package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Cart;

public interface ICartRepository extends JpaRepository<Cart, Long> {
	
}
