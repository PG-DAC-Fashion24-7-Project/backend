package com.app.controller;

import com.app.converter.ToSimpleUserInfoConverter;
import com.app.converter.ToUserConverter;
import com.app.entities.Address;
import com.app.entities.OrderDetail;
import com.app.entities.User;
import com.app.models.requestDto.ResetPasswordDto;
import com.app.models.requestDto.UserSignupDto;
import com.app.models.responseDto.AddressDto;
import com.app.services.IOrderDetail;
import com.app.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderDetail orderDetail;

    @Autowired
    private ToUserConverter toUserConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ToSimpleUserInfoConverter toSimpleUserInfoConverter;

    @GetMapping("/user/id/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        ToSimpleUserInfoConverter user = userService.getUserById(id);
        return Response.success(user);
    }
    @GetMapping("/user/getUserDetails")
    public ResponseEntity<?> getUserDetails() {
        ToSimpleUserInfoConverter userInfo =  userService.getUserDetailsByToken();
        return Response.success(userInfo);
    }
    @PostMapping("/api/public/register")
    public ResponseEntity<?> registerUser(@RequestBody UserSignupDto userSignupDto) {
        User user = userService.registerUser(userSignupDto);
        return Response.successMessage("Record Saved Successfully");
    }

    @GetMapping("/admin/all")
    public ResponseEntity<?> getAllUsers() {
        List<ToSimpleUserInfoConverter> list = userService.getAllUser();
        return Response.success(list);
    }

    @PostMapping("/user/resetpassword/")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        String msg = userService.resetPassword(resetPasswordDto);
        return Response.successMessage(msg);
    }

    @DeleteMapping("/admin/id/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if(userService.deleteUserById(id))
            return Response.successMessage("record deleted");
        return Response.error("Record NOT deleted!!");
    }

    @GetMapping("/user/getAddress/userId/{id}")
    public ResponseEntity<?> getUserAddress(@PathVariable Long id) {
        List<AddressDto> list = userService.getAllAddressByUserId(id);
        return Response.success(list);
    }

//    @GetMapping("/getOrderDetail/{id}")
//    public ResponseEntity<?> getOrderDetailByUserId (@PathVariable("id") long userId){
//    	List<OrderDetailDto> result = userService.getOrderDetailByUserId(userId);
//    	return Response.success(result);
//    }
}
