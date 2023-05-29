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
		student.setName("Sunil G");
		student.setMobile(9999999l);
		student.setAge(25);
		student.setCountry("India");
		
		session.beginTransaction();
		//Student student = session.get(Student.class, 1);
		//System.out.println(student);
		session.save(student);
		session.getTransaction().commit();

		session.close();
	}
}
