package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.sunil486.firstspringapp02.service.PaymentGateway;
import com.sunil486.firstspringapp02.service.PaymentProcessor;

//@ComponentScan
@Import(value = { GpayGatewayConfig.class, PaypalGatewayConfig.class })
public class AppConfig {

	@Bean
	public PaymentProcessor paymentProcessor(PaymentGateway paymentGateway) {

		return new PaymentProcessor(paymentGateway);
	}
}
