package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Song;
import com.sunil486.utils.HibernateUtils;

public class UpdateApp3 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		if (sessionFactory != null) {
			// 1. Initialise the session object
			Session session = sessionFactory.openSession();

			session.beginTransaction();

			Song song = session.get(Song.class, 2);

			System.out.println(song);

			//Comment this line
			//song.setSongName("Kaata lga - Updated");

			session.getTransaction().commit();

			session.close();

			song.setSongName("Kaata lga - Updated3");

			Session newSession = sessionFactory.openSession();
			newSession.beginTransaction();

			// Scenerio 3
			Song song2 = newSession.get(Song.class, 2);

			//newSession.update(song); Here Exception Occurs==> NonUniqueObjectException
			newSession.merge(song);// merge() will fix NonUniqueObjectException, song2 will also work but htis scenario is for detached object
			newSession.getTransaction().commit();

		}
	}
}
