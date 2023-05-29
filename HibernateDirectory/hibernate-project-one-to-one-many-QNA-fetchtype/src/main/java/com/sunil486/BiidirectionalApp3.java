package com.sunil486;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class BiidirectionalApp3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * 
		 * When it will trigger the LazyInitializationException
		 */

		Customer customer = session.get(Customer.class, 1);
		System.out.println("Customer mobile number is " + customer.getCustomer_mobile());
		List<Order> orders = customer.getOrders();// here order not initialized b/c i'm not accessing it
		orders.get(0).getItem_name();// here order got initialized b/c i'm accessing item name
		
		session.getTransaction().commit();
		session.close();
		System.out.println(customer.getOrders());
	}

}