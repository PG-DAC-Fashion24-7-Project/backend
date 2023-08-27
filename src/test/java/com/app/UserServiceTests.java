package com.app;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.app.entities.Address;
import com.app.entities.OrderDetail;
import com.app.entities.OrderItem;
import com.app.entities.User;
import com.app.models.responseDto.AddressDto;
import com.app.models.responseDto.OrderDetailDto;
import com.app.repository.IAddressRepository;
import com.app.repository.IOrderDetailRepository;
import com.app.repository.IOrderItemRepository;
import com.app.repository.IUserRepository;
import com.app.services.OrderDetailServiceImpl;
import com.app.services.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class UserServiceTests {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private IAddressRepository address;

    @Transactional
    @Test
    void testListAllAddress() {
//        List<Address> list = address.findByUser(new User(10L));
        List<AddressDto> list = userService.getAllAddressByUserId(10L);
        list.forEach(System.out::println);
    }

//	@Transactional
//	@Test
//	void testGetOrderDetailByUserId() {
//		List<OrderDetailDto> list = userService.getOrderDetailByUserId(9);
//		list.forEach(System.out::println);
//	}


}
