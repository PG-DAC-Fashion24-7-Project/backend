package com.app.services;

import java.util.List;

import com.app.entities.OrderDetail;
import com.app.entities.OrderItem;
import com.app.models.responseDto.OrderDetailDto;
import com.app.models.responseDto.OrderItemDto;

public interface IOrderDetail {
	List<OrderDetailDto> findAllOrderDetails();
	OrderDetailDto findOrderDetailByOrderId(long orderId);
	OrderDetailDto findOrderDetailByOrderNumber(long orderNumber);
	List<OrderDetailDto> findOrderDetailByOrderStatus(String orderStatus);
	OrderDetail saveOrderDetail(OrderDetail orderDetail);
	int deleteOrderDetailByOrderId(long orderId);
	
	List<OrderItemDto> findOrderItemByOrderId(long orderId);
	
	
	List<OrderDetailDto> getOrderDetailByUserId(long userId);
	int updateOrderStatusByOrderId(long orderId);
}
