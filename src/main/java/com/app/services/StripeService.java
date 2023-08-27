package com.app.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class StripeService {
    @Value("${stripe.secret-key}")
    private String stripeSecretKey;

    public String createPaymentIntent(Long amount) throws StripeException {
        Stripe.apiKey = stripeSecretKey;
        
        PaymentIntentCreateParams params = new PaymentIntentCreateParams.Builder()
        		.setAmount(amount)
        		.setCurrency("usd")
        		.build();
        
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        return paymentIntent.getClientSecret();
    }

}
