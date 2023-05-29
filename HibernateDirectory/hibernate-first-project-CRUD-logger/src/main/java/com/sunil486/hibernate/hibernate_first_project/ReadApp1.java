package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Song;
import com.sunil486.utils.HibernateUtils;

public class ReadApp1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		// Song song = session.get(Song.class, 2);
		Song song = session.load(Song.class, 2);
		System.out.println("Does song object managed by session : " + session.contains(song));
		session.getTransaction().commit();

		System.out.println("Getting data for id 2 : " + song);

		//session.close();
		
		// removed song object from session but session is still live not destroyed.
		// Session will destroy only when we close it
		// deatch() is from javax.persistence
		// session.detach(song);
		
		// evict() is from hibernate
		// Both detach() or evict() are doing same work
		session.evict(song);
		
		System.out.println("Does song object managed by session : " + session.contains(song));
	}
}
