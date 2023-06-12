package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("******** Calling the api method - start");
		container.getBean(Laptop.class).chargeBattery();
		System.out.println("******** Calling the api method - end");
	}
}
