package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {

		/*
		 * Person p = new Person(); System.out.println(p);
		 * 
		 * Student s = new Student();
		 * 
		 * // Approach 1 s.setName(p.getName()); s.setAddress(p.getAddress());
		 * System.out.println(s);
		 * 
		 * System.out.println("*****************************");
		 * 
		 * // Approach 2 ModelMapper mapper = new ModelMapper(); mapper.map(p, s);
		 * System.out.println(s);
		 */

		// Doing same thing using spring
		// 1. Add @Component on Person,Student and StudentInfoPrinter classes
		// 2. Add @Autowired on Person and Student class
		// 3. Add @Autowired ModelMapper class
		// 4. Use @Bean
		// AnnotationConfigApplicationContext container = new
		// AnnotationConfigApplicationContext(AppConfig.class);
		// container.getBean(StudentInfoPrinter.class).printStudentInfo();

		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.getBean(Film.class).startFilm();
	}
}
