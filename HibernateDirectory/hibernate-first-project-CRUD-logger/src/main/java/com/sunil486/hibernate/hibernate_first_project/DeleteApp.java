package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Song;
import com.sunil486.utils.HibernateUtils;

public class DeleteApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		// Load the object that we want to delete
		Song song = session.get(Song.class, 2);

		session.beginTransaction();
		// deleting the object that i have just loaded
		session.delete(song);
		session.getTransaction().commit();

		session.close();
	}
}