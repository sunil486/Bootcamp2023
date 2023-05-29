package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class CreateApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		Student student=new Student();
		student.setName("Rakhi");
		student.setMobile(9999999l);
		student.setAge(29);
		student.setCountry("India");
		
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

		session.close();
	}
}
