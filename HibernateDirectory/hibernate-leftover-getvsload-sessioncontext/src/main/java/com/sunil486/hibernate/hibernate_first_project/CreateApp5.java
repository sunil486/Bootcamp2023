package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class CreateApp5 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Student student = session.get(Student.class, 1); // fetching the record
		System.out.println(student);

		student.setName("SKG");

		System.out.println("running a flush");
		session.flush();// update will occur

		student.setAge(24);
		
		System.out.println("running a commit");
		session.getTransaction().commit();// flush + commit

		sessionFactory.close();
	}
}
