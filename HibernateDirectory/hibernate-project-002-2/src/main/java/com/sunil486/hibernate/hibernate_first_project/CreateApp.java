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

		Address homeAddress = new Address();
		homeAddress.setAddressLine1("At xyz Po xyz");
		homeAddress.setAddressLine2("yyyy");
		homeAddress.setCity("xyxx");
		homeAddress.setCountry("US");
		
		Address hostelAddress = new Address();
		hostelAddress.setAddressLine1("Bhumikar Chowk");
		hostelAddress.setAddressLine2("Icon Linera Society");
		hostelAddress.setCity("Pune");
		hostelAddress.setCountry("India");

		Student student = new Student();
		student.setName("Sunil");
		student.setMobile(9999999901l);
		student.setHomeAddress(homeAddress);
		student.setHostelAddress(hostelAddress);

		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

		session.close();
	}
}
