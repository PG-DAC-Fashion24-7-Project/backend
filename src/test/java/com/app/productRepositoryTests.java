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
import com.app.repository.IProductRepository;
import com.app.repository.IUserRepository;
import com.app.services.OrderDetailServiceImpl;
import com.app.services.ProductServiceImpl;
import com.app.services.UserServiceImpl;

@SpringBootTest
class productRepositoryTests {
	@Autowired
	private IProductRepository product;
	
	@Transactional
	@Test
	void testgetAvgRatingByProductId(){
		double result = product.getAvgRatingByProductId(4);
		System.out.println(result);
	}
	
	@Transactional
	@Test
	void testgetSumOfRatingByProductId(){
		int result = product.getSumOfRatingByProductId(4);
		System.out.println(result);
	}
}
