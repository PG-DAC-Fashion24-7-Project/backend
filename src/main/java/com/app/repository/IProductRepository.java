package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	
	Product findById(int id);
	
//List<Product> findByCategoryId(int categoryId);  //find By CategoryId
	
	List<Product> findByProductPriceGreaterThanOrderByProductPriceAsc(double ProductPrice);//find all product by price greater than specified
	
	List<Product> findByProductPriceLessThanOrderByProductPriceAsc(double ProductPrice);//find all product by price less than specified
//	List<Product> findByCategory
	
	//List<Product> findByfeedbackList(int rating);  //find By rating  // feedBack entity mapping needed

	
//	List<Product> findBySizeContaining(String size);    // search by size
	
	List<Product> findByProductDescriptionContainingIgnoreCase(String tag);    // search by Tag
	
	
	
//	@Query(value = "select sum(smallQuantity+mediumQuantity+largeQuantity+extraLargeQuantity) as sum from product", nativeQuery = true)
//	int getTotalQuantity();   // get total product quantity
	
	
	@Query(value = "select * from product order by productAddedDate desc", nativeQuery = true)
	List<Product> findByNewlyAddedProducts();   // find by latest product
	
	
	@Query(value = "select productId, productName, productDescription, least(productPrice,?1) as productPrice, productAddedDate, categoryId from product", nativeQuery = true)
	List<Product> findByAllProductWithDiscount(int discount);   // find All Product with discount by final discounted price
	
//	@Query(value = "select ps.sizeName from " ,nativeQuery = true)
	//***************************************************************************************************************************
	
	
	@Query(value = "SELECT CAST(AVG(f.rating) as decimal(10, 1)) FROM feedback f INNER JOIN product p ON f.productId = p.productId WHERE p.productId = ?1", nativeQuery = true)
	double getAvgRatingByProductId(int id);
	
	@Query(value = "SELECT SUM(f.rating) FROM feedback f INNER JOIN product p ON f.productId = p.productId WHERE p.productId = ?1", nativeQuery = true)
	int getSumOfRatingByProductId(int id);
	
	
}
