package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.OrderDetail;
import com.app.entities.OrderItem;
import com.app.models.responseDto.OrderDetailDto;
import com.app.models.responseDto.OrderItemDto;
import com.app.services.IOrderDetail;

@CrossOrigin
@RequestMapping("/user/orderdetails")
@RestController
public class OrderDetailController {
	@Autowired
	private IOrderDetail iOrderDetail;
	 
	@GetMapping("")
	public ResponseEntity<?> findAll(){
		List<OrderDetailDto> result = iOrderDetail.findAllOrderDetails();
		return Response.success(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id){
		OrderDetailDto result = iOrderDetail.findOrderDetailByOrderId(id);
		if(result == null) {
			return Response.error("Order Details Not Found");
		}
		return Response.success(result);
	}
	
	/*Causing ambiguity due to find by id and below both are GET requests ERROR: INTERNAL SERVER ERROR*/
	/*Ambiguity gone due to adding "/ON" in getmapping it make him distinct from @GetMapping("/{id}")*/
	@GetMapping("/ON/{ordernumber}")
	public ResponseEntity<?> findByOrderNumber(@PathVariable("ordernumber") int orderNumber){
		OrderDetailDto result = iOrderDetail.findOrderDetailByOrderNumber(orderNumber);
		if(result == null) {
			return Response.error("Order Details Not Found");
		}
		return Response.success(result);
	}
	
	@GetMapping("/OS/{orderstatus}")
	public ResponseEntity<?> findByOrderStatus(@PathVariable("orderstatus") String orderStatus){
		List<OrderDetailDto> result = iOrderDetail.findOrderDetailByOrderStatus(orderStatus);
		if(result == null) {
			return Response.error("Order Details Not Found");
		}
		return Response.success(result);
	}
	
	@PostMapping("")
	public ResponseEntity<?> saveOrderDetail(@RequestBody OrderDetail orderDetail){
		OrderDetail result = iOrderDetail.saveOrderDetail(orderDetail);
		return Response.success(result);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody OrderDetail orderDetail){
		orderDetail.setOrderId(id);
		OrderDetail result = iOrderDetail.saveOrderDetail(orderDetail);
		return Response.success(result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id, OrderDetail orderDetail){
		int count = iOrderDetail.deleteOrderDetailByOrderId(id);
		if (count == 0) {
			return Response.status(HttpStatus.NOT_FOUND);
		}
		return Response.success("Record deleted :"+count);
	}
	
	@GetMapping("/allOrderItemOfOrderId/{id}")
	public ResponseEntity<?> findOrderItemByOrderId(@PathVariable("id") long orderId){
		 List<OrderItemDto> result = iOrderDetail.findOrderItemByOrderId(orderId);
		 return Response.success(result);
	}
	
	@GetMapping("/getOrderDetailByUserId/{id}")
	public ResponseEntity<?> getOrderDetailByUserId(@PathVariable("id") long userId){
		List<OrderDetailDto> result = iOrderDetail.getOrderDetailByUserId(userId);
		return Response.success(result);
	}
	
	@PutMapping("/updateOrderStatus/{id}")
	public ResponseEntity<?> updateOrderStatusByOrderId(@PathVariable("id") long orderId){
		int result = iOrderDetail.updateOrderStatusByOrderId(orderId);
		if(result == 0)
			return Response.status(HttpStatus.NOT_FOUND);
		return Response.success("OrderStatus Updated");
	}
	//***************************
	@PostMapping("/updateOrderStatus/{id}")
	public ResponseEntity<?> updateOrderStatusByOrderId2(@PathVariable("id") long orderId){
		int result = iOrderDetail.updateOrderStatusByOrderId(orderId);
		if(result == 0)
			return Response.status(HttpStatus.NOT_FOUND);
		return Response.success("OrderStatus Updated");
	}
	//***************************
//	public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
//		return orderDetailRepository.save(orderDetail);
//	}

}
