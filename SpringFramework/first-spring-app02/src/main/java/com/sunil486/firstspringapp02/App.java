package com.sunil486.firstspringapp02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sunil486.firstspringapp02.config.ApplicationConfiguration;

public class App {
	public static void main(String[] args) {

		/*
		 * // Here we are doing Object creation and DI by own // Object creation Airtel
		 * airtel = new Airtel();
		 * 
		 * // Object creation Mobile mobile = new Mobile();
		 * 
		 * // Dependency Injection mobile.setSim(airtel);
		 * 
		 * mobile.accessSim();
		 */

// Give the responsibility of Object creation & DI to SPRING i.e
// replace my own code using spring

		ApplicationContext container = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		Mobile mobile = container.getBean("mobile", Mobile.class);
		mobile.accessSim();

	}
}
