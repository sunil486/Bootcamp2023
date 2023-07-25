package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sunil486.firstspringapp02.service.PaypalPaymentGateway;

@Configuration
@Profile("paypal")
public class PaypalGatewayConfig {

	@Bean
	public PaypalPaymentGateway paypalPaymentGateway() {
		return new PaypalPaymentGateway();
	}

}
