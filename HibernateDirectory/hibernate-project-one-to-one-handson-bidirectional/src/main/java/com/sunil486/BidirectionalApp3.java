package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class BidirectionalApp3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		// Create Customer ---> add some orders for that customer
		Customer customer = new Customer();
		customer.setCustomer_name("Sweetu");
		customer.setCustomer_mobile("98562886123");

		Order order1 = new Order();
		order1.setItem_name("Tripod");
		order1.setCosts(10000.00);
		order1.setCustomer(customer);// Need to do manually else it will insert null value

		Order order2 = new Order();
		order2.setItem_name("HP Pro");
		order2.setCosts(60000.00);
		order2.setCustomer(customer);// Need to do manually else it will insert null value

		// Utility method -> for adding the orders for a customer and also linking the
		// customer to a given order
		customer.addOrder(order1);
		customer.addOrder(order2);

		session.persist(customer);

		session.getTransaction().commit();
		session.close();
	}

}