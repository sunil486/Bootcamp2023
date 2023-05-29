package com.sunil486.hibernate.hibernate_first_project;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Address;
import com.sunil486.entity.Student5;
import com.sunil486.utils.HibernateUtils;

public class CreateApp5 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Student5 student = new Student5();
		student.setName("Rakhi");
		student.setMobile(9999999l);
		student.setAge(29);
		student.setCountry("India");

		// List<String> nickNames = student.getNickNames();
		Map<String, String> nickNames = student.getNickNames();
		nickNames.put("petName", "Guddu");
		nickNames.put("officeName", "Sunny");
		nickNames.put("familyName", "Sam");

		Address address = new Address();
		address.setAddressLine1("Indira nagar");
		address.setAddressLine2("kavareppa layout");
		address.setCity("Blr");
		address.setCountry("India");

		Address address2 = new Address();
		address2.setAddressLine1("Koregaon");
		address2.setAddressLine2("society layout");
		address2.setCity("mumbai");
		address2.setCountry("India");

		List<Address> addressList = student.getAddress();
		addressList.add(address);
		addressList.add(address2);

		session.save(student);
		session.getTransaction().commit();

		session.close();
	}
}
