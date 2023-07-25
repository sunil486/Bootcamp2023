package com.sunil486.firstspringapp02.service;

//@Service
public class PaymentProcessor {

	// @Autowired
	private PaymentGateway paymentGateway;

	public PaymentProcessor(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public void doPayment(int amount) {
		System.out.println("Processing payment " + amount);
		paymentGateway.pay(amount);
	}

}
