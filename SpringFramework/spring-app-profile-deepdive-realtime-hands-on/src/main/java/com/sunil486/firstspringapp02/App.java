package com.sunil486.firstspringapp02;

import java.sql.SQLException;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sunil486.firstspringapp02.service.ProductDao;
import com.sunil486.firstspringapp02.service.Test;

public class App {

	public static void main(String[] args) throws BeansException, ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();
		container.registerShutdownHook();

		container.getEnvironment().setActiveProfiles("database", "dev");

		// getting data from file
		//container.getEnvironment().setActiveProfiles("file");

		// Below will not work b/c I don't have postgreSql db in my local
		// container.getEnvironment().setActiveProfiles("database", "prod");
		container.register(AppConfig.class);
		container.refresh();

		System.out.println(container.getBean(ProductDao.class).getAllProducts());

		System.out.println(container.getBean(Test.class).getClass().getSimpleName());
	}
}
