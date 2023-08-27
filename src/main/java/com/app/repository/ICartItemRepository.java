package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CartItem;

public interface ICartItemRepository extends JpaRepository<CartItem, Long>{

}
