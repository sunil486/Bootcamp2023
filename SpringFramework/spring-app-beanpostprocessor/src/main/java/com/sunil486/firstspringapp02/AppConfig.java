package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppConfig {

	@Bean
	public static CustomBeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new CustomBeanFactoryPostProcessor();
	}
}
