package com.sunil486.firstspringapp02.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("gpay")
public class GpayPaymentGateway implements PaymentGateway {

	@Override
	public void pay(int amount) {
		System.out.println("Paying using gpay " + amount);
	}

}
