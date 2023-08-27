package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	@Query(value = "select c.categoryId from category c where c.categoryName = ?1", nativeQuery = true)
	int findCategoryIdByCategoryName(String categoryName);
	
	
}
