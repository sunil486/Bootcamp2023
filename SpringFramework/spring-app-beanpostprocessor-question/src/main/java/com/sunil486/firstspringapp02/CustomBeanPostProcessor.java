package com.sunil486.firstspringapp02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Inside CustomBeanPostProcessor : postProcessBeforeInitialization");

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Inside CustomBeanPostProcessor : postProcessAfterInitialization");

		return bean;
	}
	
}
