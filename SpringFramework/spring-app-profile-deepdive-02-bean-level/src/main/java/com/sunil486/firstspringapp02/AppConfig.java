package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import com.sunil486.firstspringapp02.service.GpayPaymentGateway;
import com.sunil486.firstspringapp02.service.PaypalPaymentGateway;

@ComponentScan
public class AppConfig {

	@Bean
	@Profile("gpay")
	public GpayPaymentGateway gpayPaymentGateway() {
		return new GpayPaymentGateway();
	}

	@Bean
	@Profile("paypal")
	public PaypalPaymentGateway paypalPaymentGateway() {
		return new PaypalPaymentGateway();
	}

}
