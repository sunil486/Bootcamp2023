package com.sunil486.firstspringapp02.service;

import org.springframework.stereotype.Component;

import com.sunil486.firstspringapp02.myannotation.PaypalProfile;

@Component
@PaypalProfile
public class PaypalPaymentGateway implements PaymentGateway {

	@Override
	public void pay(int amount) {
		System.out.println("Paying using paypal " + amount);
	}

}
