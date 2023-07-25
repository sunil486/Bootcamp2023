package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sunil486.firstspringapp02.service.PaymentProcessor;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();
		container.getEnvironment().setActiveProfiles("paypal");
		container.register(AppConfig.class);
		container.refresh();
		container.getBean(PaymentProcessor.class).doPayment(2000);
	}
}
