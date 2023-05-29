package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Passport;
import com.sunil486.utils.HibernateUtils;

public class App4 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		// Student student = session.get(Student.class, 1);
		Passport passport = session.get(Passport.class, 1001);
		System.out.println(passport);
		System.out.println(passport.getStudent());
		session.getTransaction().commit();

		session.close();
	}

}