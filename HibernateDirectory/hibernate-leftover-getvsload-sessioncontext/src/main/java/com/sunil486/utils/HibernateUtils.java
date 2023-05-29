package com.sunil486.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sunil486.entity.Student;

public class HibernateUtils {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		try {
			if (sessionFactory == null) {
				// 3. create configuration
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				configuration.addAnnotatedClass(Student.class);

				// 2. create session factory
				// SessionFactory is heavy weight
				// SessionFactory should be singleton but it is immutable
				sessionFactory = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurs while creating sessionFactory");
		}

		return sessionFactory;
	}

}
