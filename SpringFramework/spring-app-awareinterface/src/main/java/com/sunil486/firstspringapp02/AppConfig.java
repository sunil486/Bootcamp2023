package com.sunil486.firstspringapp02;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

@ComponentScan(basePackages = { "com.sunil486.firstspringapp02" })
@PropertySource("classpath:myapp.properties")
public class AppConfig {

	@Bean(name = "sachin")
	// @Scope("prototype")
	public Player player1() {
		return new Player();
	}

//	@Bean(name = "saurav")
//	public Player player2() {
//		return new Player();
//	}

	// For MessageSourceAware(I)
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("greet");
		bundleMessageSource.setDefaultEncoding("UTF-8");
		return bundleMessageSource;
	}
}
