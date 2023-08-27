package com.app.converter;

import org.springframework.stereotype.Component;

import com.app.entities.User;

@Component
public class ToSimpleUserInfoConverter {
    private Long id;
    private String name;
    private String gender;
    private Long mobileNo;
    private String email;
    private boolean isEmailVerified;
    private String role;

    public ToSimpleUserInfoConverter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ToSimpleUserInfoConverter apply(User user) {
        ToSimpleUserInfoConverter tsc = new ToSimpleUserInfoConverter();
        tsc.setId(user.getUserId());
        tsc.setEmail(user.getUserEmail());
        tsc.setMobileNo(user.getUserMobileNumber());
        tsc.setName(user.getUsername());
        tsc.setRole(user.getRole());
        tsc.setEmailVerified(user.isEmailVerified());
        tsc.setGender(user.getGender());
        return tsc;
    }



}
