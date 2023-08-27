package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.app.entities.OrderDetail;
import com.app.services.OrderDetailServiceImpl;
import com.app.services.UserServiceImpl;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
		System.out.println("this is sample");
		System.out.println("this is from localpc branch");

	}

	// Can you add @Bean methods to configure spring beans ? YES
	@Bean // <bean id , class , scope ...../>
	public ModelMapper myModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		// set property matching convention between DTO n entity : as strict
		return mapper; // config class method rets --> model mapper instance to SC --it will be managed
						// as spring bean by SC
	}

}
