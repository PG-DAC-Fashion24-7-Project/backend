package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entities.User;
import com.app.repository.IUserRepository;

@SpringBootTest
class EcommerceApplicationTests {
	@Autowired
	private IUserRepository iUserRepository;

	@Test
	void getUser() {
		User user = iUserRepository.findByUsername("Hanumant");
		System.out.println(user.getUserEmail());
	}

}
