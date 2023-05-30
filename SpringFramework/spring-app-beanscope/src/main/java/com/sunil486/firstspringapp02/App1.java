package com.sunil486.firstspringapp02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

	public static void main(String[] args) {
		ApplicationContext container1 = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
