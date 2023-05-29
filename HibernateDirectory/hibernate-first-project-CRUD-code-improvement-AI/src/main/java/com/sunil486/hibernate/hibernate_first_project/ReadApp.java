package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Song;
import com.sunil486.utils.HibernateUtils;

public class ReadApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		// Song song = session.get(Song.class, 2);
		Song song = session.load(Song.class, 2);
		session.getTransaction().commit();

		System.out.println("Getting data for id 2 : " + song);

		session.close();
	}
}
