package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Passport;
import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class App3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		Passport passport = session.get(Passport.class, 1003);

		// student ==> source/parent/owner
		Student studentAman = new Student();
		studentAman.setName("Aman Gupta");
		studentAman.setCountry("SA");
		studentAman.setPassport(passport);

		session.beginTransaction();
		session.save(studentAman);
		session.getTransaction().commit();

		session.close();
	}

}
/**
 * Make foreign key unique if we don't want any duplicate foreign key value to be inserted.
 */