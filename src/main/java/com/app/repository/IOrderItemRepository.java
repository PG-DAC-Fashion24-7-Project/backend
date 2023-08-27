package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long>{
	OrderItem findByOrderItemId(long orderItemId);
//	List<OrderItem> findByOrderItemIdOrderByProductPrice(long orderItemId);
//	List<OrderItem> findByOrderItemIdOrderByProductQuantity(long orderItemId);
	
	@Query("SELECT OI.orderdetail.orderId, OI.orderItemId FROM OrderItem OI")
	public List<Object[]> findAllOrderItemIdOrderDetailId2();
	
//	@Query("SELECT OI.orderdetail.orderId, ")
//	public List<OrderItem> findByOrderId(long orderId);
	
	
	
	

}

