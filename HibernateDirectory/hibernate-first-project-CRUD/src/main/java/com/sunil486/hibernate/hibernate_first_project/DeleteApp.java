package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sunil486.entity.Song;

public class DeleteApp 
{
    public static void main( String[] args )
    {
      SessionFactory sessionFactory = getSessionFactory();
      
      //1. Initialise the session object
      Session session = sessionFactory.openSession();
      
      //Load the object that we want to delete
      Song song = session.get(Song.class, 2);
      
      session.beginTransaction();
      //deleting the object that i have just loaded
      session.delete(song);
      session.getTransaction().commit();
      
      session.close();
    }

	private static SessionFactory getSessionFactory() {
		  //3. create configuration 
		  Configuration configuration= new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  configuration.addAnnotatedClass(Song.class);
		  
		  //2. create session factory
		  //SessionFactory is heavy weight
		  //SessionFactory should be singleton but it is immutable
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
}