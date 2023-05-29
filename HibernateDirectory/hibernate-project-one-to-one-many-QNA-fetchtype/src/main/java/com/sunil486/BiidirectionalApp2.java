package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.utils.HibernateUtils;

public class BiidirectionalApp2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * 
		 * When it will trigger the LazyInitializationException?
		 * 
		 * If session is closed and the proxy has not initialized and you are trying to
		 * access the non-initialized proxy
		 */

		Customer customer = session.get(Customer.class, 1);
		System.out.println("Customer mobile number is " + customer.getCustomer_mobile());
		System.out.println(customer.getOrders());
		session.getTransaction().commit();
		session.close();
		System.out.println(customer.getOrders());
	}

}