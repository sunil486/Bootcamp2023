package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class ManyToOneApp3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Customer customer = new Customer();
		customer.setCustomer_name("Sunil");
		customer.setCustomer_mobile("945675432");

		Order order0 = new Order();
		order0.setItem_name("TV");
		order0.setCosts(54000.00);
		order0.setCustomer(customer);

		Order order1 = new Order();
		order1.setItem_name("Mobile");
		order1.setCosts(64000.00);
		order1.setCustomer(customer);

		// case4 --> CascadeType.PERSIST
		session.persist(order0);
		session.persist(order1);

		session.getTransaction().commit();

		session.close();
	}

}