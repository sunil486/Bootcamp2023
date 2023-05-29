package com.sunil486;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class BiidirectionalApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * What is the default fetch type for @OneToMany ==> LAZY
		 * 
		 * What is the default fetch type for @ManyToOne ==> EAGER
		 * 
		 * When it will trigger the LazyInitializationException ==> If session is closed
		 * and the proxy has not initialized and you are trying to access the
		 * non-initialized proxy
		 */

		Customer customer = session.get(Customer.class, 1);
		// Add 2 System.out.println() and check generated query on console
		// Ask this with Abhilash???
		System.out.println("Customer mobile number is " + customer.getCustomer_mobile());
		List<Order> orders = customer.getOrders();
		orders.forEach(order -> System.out.println(order.getItem_name() + " - " + order.getCosts()));

		session.getTransaction().commit();
		session.close();
	}

}