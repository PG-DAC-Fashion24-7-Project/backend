package com.app;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Feedback;
import com.app.entities.OrderDetail;
import com.app.entities.OrderItem;
import com.app.entities.User;
import com.app.repository.IFeedbackRepository;
import com.app.repository.IOrderDetailRepository;
import com.app.repository.IOrderItemRepository;
import com.app.repository.IUserRepository;
import com.app.services.OrderDetailServiceImpl;
import com.app.services.UserServiceImpl;

@SpringBootTest
class FeedbackRepositoryTests {
	@Autowired
	private IFeedbackRepository feedback;
	
	@Transactional
	@Test
	void testfindAllFeedback() {
		List<Feedback> list = feedback.findAll();
		list.forEach(System.out::println);
	}
	
	@Transactional
	@Test
	void testfindAllCommentByProductId() {
		List<Object[]> list = feedback.findAllCommentByProductId(4);
		list.forEach(arr -> System.out.println(arr[0] + " - " + arr[1]));
	}
	
	@Transactional
	@Test
	void testfindAllRatingByProductId() {
		List<Object[]> list = feedback.findAllRatingByProductId(4);
		list.forEach(arr -> System.out.println(arr[0]));
	}
	
//	@Transactional
//	@Test
//	void testaddCommentByProductId() {
//		list = feedback.addCommentByProductId();
//		list.forEach(arr -> System.out.println(arr[0]));
//	}
}
