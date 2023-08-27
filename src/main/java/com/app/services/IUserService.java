package com.app.services;

import com.app.converter.ToSimpleUserInfoConverter;
import com.app.entities.Address;
import com.app.entities.OrderDetail;
import com.app.entities.User;
import com.app.models.requestDto.ResetPasswordDto;
import com.app.models.requestDto.UserSignupDto;
import com.app.models.responseDto.AddressDto;
import com.app.models.responseDto.OrderDetailDto;

import java.util.List;

public interface IUserService {
	User getUserByName(String name);
	ToSimpleUserInfoConverter getUserById(Long id);
	User getUserByEmail(String email);
	User registerUser(UserSignupDto userSignupDto);
	List<ToSimpleUserInfoConverter> getAllUser();
	boolean deleteUserById(Long id);
	User getUserByToken();
	String resetPassword(ResetPasswordDto resetPasswordDto);
	ToSimpleUserInfoConverter getUserDetailsByToken();
	List<AddressDto> getAllAddressByUserId(Long userId);
	//List<OrderDetailDto> getOrderDetailByUserId(long userId);
}
