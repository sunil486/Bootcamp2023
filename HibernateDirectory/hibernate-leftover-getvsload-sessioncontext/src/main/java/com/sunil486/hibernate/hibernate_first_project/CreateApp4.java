package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.utils.HibernateUtils;

public class CreateApp4 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object

		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();

		System.out.println(session1 + " " + session2);
		
		if(session1==session2) {
			System.out.println("Both session objects are same");
		}
		else {
			System.out.println("Both session objects are not same");
		}
		
		
		Session session3 = sessionFactory.getCurrentSession();
		Session session4 = sessionFactory.getCurrentSession();

		System.out.println(session3 + " " + session4);
		
		if(session3==session4) {
			System.out.println("Both session objects are same");
		}
		else {
			System.out.println("Both session objects are not same");
		}
		
		sessionFactory.close();
	}
}
