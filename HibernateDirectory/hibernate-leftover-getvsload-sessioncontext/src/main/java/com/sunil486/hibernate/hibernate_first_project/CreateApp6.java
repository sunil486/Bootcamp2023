package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class CreateApp6 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// Student student = session.get(Student.class, 1);
		Student student = session.get(Student.class, 8);
		//Student student = session.load(Student.class, 8);
		System.out.println("printing student object");
		System.out.println(student.getAge());

		session.getTransaction().commit();// flush + commit

		sessionFactory.close();
	}
}
