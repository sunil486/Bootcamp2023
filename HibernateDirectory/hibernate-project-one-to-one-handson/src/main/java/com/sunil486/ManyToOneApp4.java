package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class ManyToOneApp4 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Order order = session.get(Order.class, 1);
		order.setCustomer(null);
		session.delete(order);

		session.getTransaction().commit();

		session.close();
	}

}