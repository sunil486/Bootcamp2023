package com.sunil486;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class BidirectionalApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * //Getting customer from order here Order order = session.get(Order.class, 1);
		 * System.out.println(order.getCustomer().getCustomer_name());
		 */

		// Getting order from customer here
		Customer customer = session.get(Customer.class, 1);
		List<Order> orders = customer.getOrder();

		orders.forEach(System.out::println);

		session.getTransaction().commit();

		session.close();
	}

}