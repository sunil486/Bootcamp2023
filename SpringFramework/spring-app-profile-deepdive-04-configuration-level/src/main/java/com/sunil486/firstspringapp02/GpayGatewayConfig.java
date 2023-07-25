package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sunil486.firstspringapp02.service.GpayPaymentGateway;

@Configuration
@Profile("gpay")
public class GpayGatewayConfig {

	@Bean
	public GpayPaymentGateway gpayPaymentGateway() {
		return new GpayPaymentGateway();
	}

}
