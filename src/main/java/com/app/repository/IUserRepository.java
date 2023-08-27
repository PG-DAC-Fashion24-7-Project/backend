package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	User findByUserId(long userId);
	
	
	User findByUsername(String name);
	User findByUserEmail(String email);
}
