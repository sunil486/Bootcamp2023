package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.AccessCard;
import com.sunil486.utils.HibernateUtils;

public class App3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		/*
		 * case1 Employee employee = session.get(Employee.class, 1);
		 * session.delete(employee);
		 */

		// case2
		AccessCard accessCard = session.get(AccessCard.class, 2);
		accessCard.getEmployee().setCard(null); // This is very important
		session.delete(accessCard);

		session.getTransaction().commit();

		session.close();
	}

}