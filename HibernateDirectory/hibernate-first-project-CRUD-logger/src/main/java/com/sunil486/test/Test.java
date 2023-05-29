package com.sunil486.test;

import org.hibernate.SessionFactory;

import com.sunil486.utils.HibernateUtils;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory1 = HibernateUtils.getSessionFactory();

		SessionFactory sessionFactory2 = HibernateUtils.getSessionFactory();
		
		if(sessionFactory1 == sessionFactory2) {
			System.out.println("Both SessionFactory objects are same");
		}
		
		System.out.println(sessionFactory1.hashCode() + " " + sessionFactory2.hashCode());
	}

}
