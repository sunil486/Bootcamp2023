package com.sunil486.firstspringapp02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Component
public class Laptop
		implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean {

	private Battery battery;

	public Laptop() {
		System.out.println("Laptop is initializing");
	}

	@Autowired
	public void setBattery(Battery battery) {
		System.out.println("Setting property");
		this.battery = battery;
	}

	@PostConstruct
	public void runAtStart() {
		System.out.println("Inside runAtStart() method");
	}

	public void initMethod() {
		System.out.println("Inside initMethod()");
	}

	public void chargeBattery() {
		battery.charge();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertiesSet() callback method");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("#BeanNameAware");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("#BeanFactoryAware");

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("#ApplicationContextAware");

	}

	@PreDestroy
	public void destroy1() throws Exception {
		System.out.println("destroy1() method called - @PreDestroy");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() method called - DisposableBean");

	}
	
	public void myOwnDestroy() throws Exception {
		System.out.println("myOwnDestroy() method called - Bean destroy property");

	}
	
}
