package com.sunil486;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunil486.entity.Actor;
import com.sunil486.entity.Movie;
import com.sunil486.utils.HibernateUtils;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Movie dhoom = new Movie("Dhoom");
		Actor amirKhan = new Actor("Amir Khan");
		Actor katrina = new Actor("Katrina");
		Actor abhishek = new Actor("Abhishekh B");

		dhoom.addActor(amirKhan);
		dhoom.addActor(katrina);
		dhoom.addActor(abhishek);

		session.save(dhoom);

		session.getTransaction().commit();
		session.close();
	}

}