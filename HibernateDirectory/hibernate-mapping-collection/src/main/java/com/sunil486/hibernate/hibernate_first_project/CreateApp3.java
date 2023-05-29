package com.sunil486.hibernate.hibernate_first_project;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class CreateApp3 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		Student student = new Student();
		student.setName("Rakhi");
		student.setMobile(9999999l);
		student.setAge(29);
		student.setCountry("India");

		// List<String> nickNames = student.getNickNames();
		Map<String, String> nickNames = student.getNickNames();
		nickNames.put("petName","Guddu");
		nickNames.put("officeName","Sunny");
		nickNames.put("familyName","Sam");

		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

		session.close();
	}
}
