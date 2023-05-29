package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.AccessCard;
import com.sunil486.entity.Employee;
import com.sunil486.utils.HibernateUtils;

public class App2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		AccessCard accessCard = new AccessCard();
		accessCard.setAccessCardNumber("8234567");

		Employee employee = new Employee();
		employee.setEmpName("Sunil");
		employee.setCountry("India");
		employee.setCard(accessCard);

		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();

		session.close();
	}

}