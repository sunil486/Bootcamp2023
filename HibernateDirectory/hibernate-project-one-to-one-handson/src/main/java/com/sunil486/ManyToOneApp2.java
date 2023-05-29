package com.sunil486;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class ManyToOneApp2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Customer customer = new Customer();
		customer.setCustomer_name("Sunil");
		customer.setCustomer_mobile("945675432");

		Order order = new Order();
		order.setItem_name("TV");
		order.setCosts(54000.00);
		order.setCustomer(customer);

		// case1 --> CascadeType.ALL
		// session.save(order);

		// case2 --> CascadeType.PERSIST
		//session.save(order);

		// case3 --> CascadeType.PERSIST
		session.persist(order);

		session.getTransaction().commit();

		session.close();
	}

}