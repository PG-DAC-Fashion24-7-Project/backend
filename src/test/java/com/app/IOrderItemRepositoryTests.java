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
import com.app.repository.IOrderDetailRepository;
import com.app.repository.IOrderItemRepository;
import com.app.repository.IUserRepository;

@SpringBootTest
class IOrderItemRepositoryTests {
	@Autowired
	private IOrderItemRepository iOrderItemRepository;
	
	@Test
	void testFindAll() {
		List<OrderItem> list= iOrderItemRepository.findAll();
		list.forEach(System.out::println);
	}
	
	@Transactional
	@Test
	void testFindByOrderItemId() {
		OrderItem orderItem = iOrderItemRepository.findByOrderItemId(2);
		System.out.println("Found by Id: "+orderItem);
		System.out.println(orderItem.getOrderdetail());
	}
	
	
	@Transactional
	@Test
	void testfindAllOrderItemIdOrderDetailId2() {
		List<Object[]> list = iOrderItemRepository.findAllOrderItemIdOrderDetailId2();
		list.forEach(arr -> System.out.println(arr[0] + " , " + arr[1]));
	}
	

	
//	@Test
//	void testfindByOrderItemIdOrderByProductPrice() {
//		List<OrderItem> list = iOrderItemRepository.findByOrderItemIdOrderByProductPrice(2);
//		list.forEach(System.out::println);
//	}
//	
//	@Test
//	void testfindByOrderItemIdOrderByProductQuantity() {
//		List<OrderItem> list = iOrderItemRepository.findByOrderItemIdOrderByProductQuantity();
//		list.forEach(System.out::println);
//	}
	
//	@Rollback(false)
//	@Transactional
//	@Test
//	void testSave() {
//		OrderDetail orderDetail = new OrderDetail(0, 103, "ordered", new Date(), 5690.00, 2);
//		iOrderRepository.save(orderDetail);
//	}
//	
//	@Test
//	void testFindByOrderNumber() {
//		OrderDetail orderDetail = iOrderRepository.findByOrderNumber(102);
//		System.out.println("Found by Number: "+orderDetail);
//	}
	
	
}
