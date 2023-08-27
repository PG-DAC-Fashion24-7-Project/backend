package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Address;
import com.app.entities.User;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUser(User user);
}
