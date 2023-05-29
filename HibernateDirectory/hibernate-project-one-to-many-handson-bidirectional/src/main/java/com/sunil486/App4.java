package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Employee;
import com.sunil486.utils.HibernateUtils;

public class App4 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*
		 * //Case1 Employee employee = session.get(Employee.class, 1);
		 * System.out.println("Employee with name " + employee.getEmpName() +
		 * " is from " + employee.getCountry());
		 */

		// Case2
		Employee employee = session.get(Employee.class, 1);
		System.out.println("Employee with name " + employee.getEmpName() + " is from " + employee.getCountry());
		System.out.println("Employee with access card number " + employee.getCard().getAccessCardNumber() + " is from " + employee.getCountry());
		
		session.getTransaction().commit();

		session.close();
	}

}