package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Song;
import com.sunil486.utils.HibernateUtils;

public class UpdateApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		if(sessionFactory != null) {
		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		// Problem with this approach--> null value will be updated in db if we miss to
		// set any field
		/*
		 * Song song = new Song(); song.setId(2);
		 * song.setSongName("Kaata lga - Updated");
		 * 
		 * session.beginTransaction(); session.update(song);
		 * session.getTransaction().commit();
		 */

		/* 2nd Approach
		 * Song song = session.get(Song.class, 2);
		 * song.setSongName("Kaata lga - Updated");
		 * 
		 * session.beginTransaction(); session.update(song);
		 * session.getTransaction().commit();
		 */
		
		// 3rd Approach
		//But how this is happening
		Song song = session.get(Song.class, 2);

		session.beginTransaction();
		song.setSongName("Kaata lga - Updated");
		session.getTransaction().commit();

		session.close();
	}
	}
}
