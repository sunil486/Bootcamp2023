package com.sunil486.firstspringapp02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanInfo implements BeanFactoryAware {

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("##BeanFactoryAware setBeanFactory() method");
		//System.out.println("Is sachin bean singleton? " + beanFactory.isSingleton("sachin"));
	}

}
