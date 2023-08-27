package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.StripeService;
import com.stripe.exception.StripeException;

@CrossOrigin
@RequestMapping("/api/payment")
@RestController
public class PaymentController {
	@Autowired
	private StripeService stripeService;
	
	@PostMapping("/create-payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestParam Long amount) {
		try {
			String clientSecret = stripeService.createPaymentIntent(amount);
			return ResponseEntity.ok(clientSecret);
		} catch (StripeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating payment intent");
		}
	}
	

}
