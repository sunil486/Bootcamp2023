package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class BiidirectionalApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * delete an order and it's associated customer
		 * 
		 * It can be achieved using orphanRemoval
		 * 
		 * @OneToMany(mappedBy = "customer", orphanRemoval = true)
		 */

		Order order = session.get(Order.class, 10);
		session.delete(order);

		session.getTransaction().commit();
		session.close();
	}

}