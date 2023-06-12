package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppConfig {

	@Bean
	public static CustomBeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new CustomBeanFactoryPostProcessor();
	}

	@Bean
	public static CustomBeanPostProcessor beanPostProcessor() {
		return new CustomBeanPostProcessor();
	}

	@Bean(initMethod = "initMethod", destroyMethod = "myOwnDestroy")
	public Laptop laptop() {
		return new Laptop();
	}
}
