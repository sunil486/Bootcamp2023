package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Passport;
import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		// passport ==> target/child
		Passport amanPassport = new Passport();
		amanPassport.setPassportNumber("56123245R");

		// student ==> source/parent/owner
		Student studentAman = new Student();
		studentAman.setName("Aman Gupta");
		studentAman.setCountry("SA");
		studentAman.setPassport(amanPassport);

		session.beginTransaction();
		session.save(amanPassport);
		session.save(studentAman);
		session.getTransaction().commit();

		session.close();
	}

}
