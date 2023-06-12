package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
//		Teacher teacher = container.getBean("teacher", Teacher.class);
//		teacher.init();// to overcome NPE, call init() method first manually then teach() method
//		teacher.teach();

		Teacher teacher = container.getBean("teacher", Teacher.class);
		teacher.teach();

		/*
		 * System.out.println("Destroy container using close() method"); // Using
		 * close() method with ApplicationContext ApplicationContext container2 = new
		 * AnnotationConfigApplicationContext(AppConfig.class); Teacher teacher2 =
		 * container.getBean("teacher", Teacher.class); teacher.teach();
		 * ((AnnotationConfigApplicationContext) container).close();
		 * 
		 * System.out.println("Destroy container using close() method"); // Using
		 * close() method AnnotationConfigApplicationContext
		 * AnnotationConfigApplicationContext container3 = new
		 * AnnotationConfigApplicationContext(AppConfig.class); Teacher teacher3 =
		 * container.getBean("teacher", Teacher.class); teacher.teach();
		 * container3.close();
		 * 
		 * System.out.println("Destroy container using try with resources java 1.7"); //
		 * Using try with resources try (AnnotationConfigApplicationContext container4 =
		 * new AnnotationConfigApplicationContext(AppConfig.class)) { Teacher teacher4 =
		 * container.getBean("teacher", Teacher.class); teacher.teach(); }
		 */

		System.out.println("Destroy container using java registerShutdownHook()");
		// Using Java registerShutdownHook()
		AnnotationConfigApplicationContext container5 = new AnnotationConfigApplicationContext(AppConfig.class);
		Teacher teacher5 = container.getBean("teacher", Teacher.class);
		teacher.teach();
		container5.registerShutdownHook();

	}
}
