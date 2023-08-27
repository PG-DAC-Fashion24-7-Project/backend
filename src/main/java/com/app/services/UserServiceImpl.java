package com.app.services;

import com.app.converter.ToSimpleUserInfoConverter;
import com.app.converter.ToUserConverter;
import com.app.entities.*;
import com.app.exception.customexceptions.NoAddressFoundException;
import com.app.exception.customexceptions.PasswordMismatchException;
import com.app.exception.customexceptions.UserAlreadyExistsException;
import com.app.exception.customexceptions.UserNotFoundException;
import com.app.models.requestDto.ResetPasswordDto;
import com.app.models.requestDto.UserSignupDto;
import com.app.models.responseDto.AddressDto;
import com.app.models.responseDto.DtoEntityConverter;
import com.app.models.responseDto.OrderDetailDto;
import com.app.models.responseDto.OrderItemDto;
import com.app.repository.IAddressRepository;
import com.app.repository.IFeedbackRepository;
import com.app.repository.IOrderDetailRepository;
import com.app.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Autowired
    private DtoEntityConverter converter;

    @Autowired
    private ToUserConverter toUserConverter;

    @Autowired
    private ToSimpleUserInfoConverter toSimpleUserInfoConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public ToSimpleUserInfoConverter getUserById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null)
            throw new UserNotFoundException("User Not Found");
        ToSimpleUserInfoConverter toSimpleUserInfo = toSimpleUserInfoConverter.apply(user);
        return toSimpleUserInfo;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    public User registerUser(UserSignupDto userSignupDto) {
        User user = getUserByEmail(userSignupDto.getEmail());
        if (user != null)
            throw new UserAlreadyExistsException("User Already Exists!!");
        if (!userSignupDto.getPassword().equals(userSignupDto.getConfirmPassword()))
            throw new PasswordMismatchException("Password does not match!!");
        User savedUser = toUserConverter.apply(userSignupDto);
        return userRepository.save(savedUser);
    }

    @Override
    public List<ToSimpleUserInfoConverter> getAllUser() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty())
            throw new UserNotFoundException("Users Not Found");
        List<ToSimpleUserInfoConverter> simpleUserList = new ArrayList<>();
        userList.forEach(user ->
                simpleUserList.add(toSimpleUserInfoConverter.apply(user))
        );
        return simpleUserList;
    }

    @Override
    public boolean deleteUserById(Long id) {
        ToSimpleUserInfoConverter user = getUserById(id);
        if (user == null)
            throw new UserNotFoundException("User Not Found!!");
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User getUserByToken() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = getUserByEmail(userEmail);
        if (user == null)
            throw new UserNotFoundException("Invalid User!!");
        return user;
    }

    @Override
    public String resetPassword(ResetPasswordDto resetPasswordDto) {
        User user = getUserByToken();

        if (!passwordEncoder.matches(resetPasswordDto.getOldPassword(), user.getPassword()))
            throw new PasswordMismatchException("Old password doest not match");
        if (!resetPasswordDto.getNewPassword().equals(resetPasswordDto.getConfirmPassword()))
            throw new PasswordMismatchException("Confirm password doest not match");
        user.setPassword(passwordEncoder.encode(resetPasswordDto.getNewPassword()));
        User updatedUser = userRepository.save(user);
        if (updatedUser == null)
            throw new PasswordMismatchException("Something else went wrong");

        return "password updated successfully";

    }

    @Override
    public ToSimpleUserInfoConverter getUserDetailsByToken() {
        User user = getUserByToken();
        return toSimpleUserInfoConverter.apply(user);
    }

    @Override
    public List<AddressDto> getAllAddressByUserId(Long userId) {
        List<Address> list = addressRepository.findByUser(new User(userId));
        if (list.isEmpty())
            throw new NoAddressFoundException("No Address linked yet!!");
        return list.stream().map(address -> new AddressDto(address.getAddressId(),
                address.getAddressLine1(),
                address.getAddressLine2(),
                address.getCity(),
                address.getState(),
                address.getPin(),
                address.getCountry(),
                address.getUser().getUserId())).collect(Collectors.toList());
    }


    //get order details by user Id
//	public List<OrderDetailDto> getOrderDetailByUserId(long userId){
//		List<OrderDetail> orderDetailList = userRepository.findById(userId).getOrderDetailList();
//		return orderDetailList.stream()
//				.map(orderdetail -> converter.toOrderDetailDto(orderdetail))
//				.collect(Collectors.toList());
//	}


//	//add comment by user Id
//	public List<Object[]> saveCommentByUserId(long userId){
//		User user = userRepository.findbyUserId(userId);
//		List<Feedback> feedback = user.getFeedbackList();
//		feedback
//	}


}
