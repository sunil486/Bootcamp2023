package com.sunil486.firstspringapp02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person = container.getBean("person", Person.class);

		person.printPersonInfo();
	}
}
