package com.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.OrderDetail;
import com.app.entities.OrderItem;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	OrderDetail findByOrderId(long orderId);
	OrderDetail findByOrderNumber(long orderNumber);
	List<OrderDetail> findByOrderStatus(String orderStatus);
	
	//get sum of all OrderItem's product quantity
//	//@Formula("(select sum(children.height) from children_table children inner join Parent p on children.parent_id=p.id where children.parent_id=parent_id)")
//	@Formula("(select sum(orderitem.productQuantity) from OrderItem orderitem inner join OrderDetail orderdetail on orderitem.orderId = orderdetail.orderId where orderitem.orderId = orderId)")

	@Transactional
	@Modifying
	@Query(value = "UPDATE orderdetails SET orderStatus='Cancelled' WHERE orderId = ?1", nativeQuery = true)
	int updateOrderStatusByOrderId(long orderId);
	
}
