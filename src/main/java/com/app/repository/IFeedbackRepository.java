package com.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Feedback;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long>{
	Feedback findByFeedbackId(long id);
//	List<Feedback> findCommentByProductId(long productId);
//	List<Feedback> findRatingByProductId(long productId);
	
	List<Feedback> findAll();
	
	@Query(value = "SELECT f.comment, f.commentDate FROM feedback f INNER JOIN product p ON f.productId = p.productId WHERE p.productId = ?1", nativeQuery = true)
	public List<Object[]> findAllCommentByProductId(int productId);
	
	@Query(value = "SELECT f.rating FROM feedback f INNER JOIN product p ON f.productId = p.productId WHERE p.productId = ?1", nativeQuery = true)
	public List<Object[]> findAllRatingByProductId(int productId);
	
//	insert into "order" (customer_id, price) values \
//	((select customer_id from customer where name = 'John'), 12.34);
//	@Modifying
//	@Query(value = "INSERT INTO feedback (productId, comment, commentDate) VALUES ((SELECT productId FROM product WHERE productId = ?1), ?1, ?1)", nativeQuery = true)
//	int addCommentByProductId(int productId, String comment, Date commentDate);
	

	
	
}
