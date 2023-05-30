package com.sunil486.firstspringapp02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext container1 = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person1 = container1.getBean("person", Person.class);
		System.out.println(person1);

		Person person2 = container1.getBean("person", Person.class);
		System.out.println(person2);

		if (person1 == person2) {
			System.out.println("Beans are same in container1");
		} else {
			System.out.println("Beans are not same in container1");
		}

		ApplicationContext container2 = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person3 = container2.getBean("person", Person.class);
		System.out.println(person3);

		Person person4 = container2.getBean("person", Person.class);
		System.out.println(person4);

		if (person1 == person3) {
			System.out.println("Beans are same");
		} else {
			System.out.println("Beans are not same");
		}

	}
}
