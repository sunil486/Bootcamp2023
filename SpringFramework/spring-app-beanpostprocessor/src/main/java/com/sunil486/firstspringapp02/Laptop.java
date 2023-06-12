package com.sunil486.firstspringapp02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

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

	public void chargeBattery() {
		battery.charge();
	}
}
