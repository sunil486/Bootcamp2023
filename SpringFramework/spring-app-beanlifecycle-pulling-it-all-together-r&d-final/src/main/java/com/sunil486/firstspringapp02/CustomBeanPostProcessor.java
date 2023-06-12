package com.sunil486.firstspringapp02;

import java.util.Objects;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if (Objects.equals(beanName, "laptop")) {
			System.out.println("Inside CustomBeanPostProcessor : postProcessBeforeInitialization " + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if (Objects.equals(beanName, "laptop")) {
			System.out.println("Inside CustomBeanPostProcessor : postProcessAfterInitialization " + beanName);
		}

		return bean;
	}

}
