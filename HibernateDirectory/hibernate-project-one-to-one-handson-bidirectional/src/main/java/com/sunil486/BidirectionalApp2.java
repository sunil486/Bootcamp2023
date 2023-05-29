package com.sunil486;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Customer;
import com.sunil486.entity.Order;
import com.sunil486.utils.HibernateUtils;

public class BidirectionalApp2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * // Create Customer ---> add some orders for that customer Customer customer =
		 * new Customer(); customer.setCustomer_name("Ekta");
		 * customer.setCustomer_mobile("98562886123");
		 * 
		 * List<Order> orderList = new ArrayList<Order>(); Order order1 = new Order();
		 * order1.setItem_name("Mic"); order1.setCosts(60000.00); // Need to do manually
		 * else it will insert null value order1.setCustomer(customer);
		 * 
		 * Order order2 = new Order(); order2.setItem_name("Camera");
		 * order2.setCosts(980000.00); // Need to do manually else it will insert null
		 * value order2.setCustomer(customer);
		 * 
		 * orderList.add(order1); orderList.add(order2);
		 * 
		 * customer.setOrder(orderList);
		 * 
		 * session.persist(customer);
		 */

		Customer customer = session.get(Customer.class, 6);// Ekta
		Order order = session.get(Order.class, 1);// Mobile - Sunil 1 ==> changed to Ekta
		
		//this is important line
		order.setCustomer(customer);// Here also we have to do it manually

		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order);

		/*
		 * This 2 lines will work same as below single line //
		 * customer.setOrder(orderList); 
		 * session.update(customer);
		 */

		customer.setOrder(orderList);// dirty checking will occur here, so no need of session.update(customer);

		session.getTransaction().commit();
		session.close();
	}

}