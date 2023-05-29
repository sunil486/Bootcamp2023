package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Song;
import com.sunil486.utils.HibernateUtils;

public class UpdateApp2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		if(sessionFactory != null) {
		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		Song song = session.get(Song.class, 2);
		
		System.out.println(song);
		
		song.setSongName("Kaata lga - Updated");
		
		session.getTransaction().commit();

		session.close();
		
		//Scenerio 1
		song.setSongName("Kaata lga - Updated2");
		
		System.out.println(song);
		
	}
	}
}
