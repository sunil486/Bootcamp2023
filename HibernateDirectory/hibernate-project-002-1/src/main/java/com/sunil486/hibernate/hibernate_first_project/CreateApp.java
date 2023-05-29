package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Address;
import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class CreateApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		Address address = new Address();
		address.setAddressLine1("Bhumikar Chowk1");
		address.setAddressLine2("Icon Linera Society1");
		address.setCity("Blr1");
		address.setCountry("India1");

		Student student = new Student();
		student.setName("Sunil1");
		student.setMobile(9999999901l);
		student.setAddress(address);

		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

		session.close();
	}
}
