package com.app;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.OrderDetail;
import com.app.entities.OrderItem;
import com.app.entities.User;
import com.app.models.responseDto.OrderItemDto;
import com.app.repository.IOrderDetailRepository;
import com.app.repository.IOrderItemRepository;
import com.app.repository.IUserRepository;
import com.app.services.OrderDetailServiceImpl;

@SpringBootTest
class OrderItemServiceTests {
	@Autowired
	private OrderDetailServiceImpl orderDetail;
	
	@Transactional
	@Test
	void testfindOrderItemByOrderId() {
		List<OrderItemDto> list = orderDetail.findOrderItemByOrderId(2);
		list.forEach(System.out::println);
	}

	
	
	
}
