package com.sunil486.firstspringapp02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("Inside CustomBeanFactoryPostProcessor : postProcessBeanFactory");

		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getBeanClassName().endsWith("Laptop")) {
				// beanDefinition.setScope("prototype");
				beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);// recommended way
				// Calling initMethod()
				beanDefinition.setInitMethodName("initMethod");
			}
			System.out.println(beanDefinition);
		}

	}

}
