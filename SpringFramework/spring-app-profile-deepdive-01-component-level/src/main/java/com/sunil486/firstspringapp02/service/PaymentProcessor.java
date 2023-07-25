package com.sunil486.firstspringapp02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessor {

	@Autowired
	private PaymentGateway paymentGateway;

	public void doPayment(int amount) {
		System.out.println("Processing payment " + amount);
		paymentGateway.pay(amount);
	}

}
