package com.sunil486.firstspringapp02.service;

public class GpayPaymentGateway implements PaymentGateway {

	@Override
	public void pay(int amount) {
		System.out.println("Paying using gpay " + amount);
	}

}
