package com.sunil486;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class UnidirectionalApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * find all the orders associated with a given customer. if we do have
		 * bidirectional relation Customer customer = session.get(Customer.class, 7);
		 * List<Order> orders = customer.getOrder(); orders.forEach(order ->
		 * System.out.println(order));
		 */

		/*
		 * find all the orders associated with a given customer. if we don't have
		 * bidirectional relation i.e commenting below
		 * 
		 * @OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST }) private
		 * List<Order> orders; in Customer.java
		 * 
		 * Can be achieved using native query as below
		 */

		List<Order> orderList = session
				.createQuery("Select o from Order o where o.customer.customer_id=:CUSTID", Order.class)
				.setParameter("CUSTID", 7).list();

		orderList.forEach(order -> System.out.println(order));

		session.getTransaction().commit();
		session.close();
	}

}