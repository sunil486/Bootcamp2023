package com.sunil486.firstspringapp02;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class Laptop implements InitializingBean {

	private Battery battery;

	public Laptop() {
		System.out.println("Laptop is initializing");
	}

	@Autowired
	public void setBattery(Battery battery) {
		System.out.println("Setting property");
		this.battery = battery;
	}

	public void initMethod() {
		System.out.println("Inside initMethod()");
	}

	@PostConstruct
	public void runAtStart() {
		System.out.println("Inside runAtStart() method");
	}

	public void chargeBattery() {
		battery.charge();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertiesSet() callback method");
	}
}
