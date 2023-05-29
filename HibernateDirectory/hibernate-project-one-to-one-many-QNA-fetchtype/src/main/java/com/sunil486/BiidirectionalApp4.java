package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class BiidirectionalApp4 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * 
		 * What is the default fetch type for @ManyToOne ==> EAGER
		 */

		Order order = session.get(Order.class, 2);
		System.out.println(order);
		System.out.println(order.getCustomer().getCustomer_name());

		session.getTransaction().commit();
		session.close();
	}

}