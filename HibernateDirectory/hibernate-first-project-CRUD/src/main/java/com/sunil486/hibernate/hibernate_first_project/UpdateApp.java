package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sunil486.entity.Song;

public class UpdateApp 
{
    public static void main( String[] args )
    {
      //3. create configuration 
      Configuration configuration= new Configuration();
      configuration.configure("hibernate.cfg.xml");
      configuration.addAnnotatedClass(Song.class);
      
      //2. create session factory
      //SessionFactory is heavy weight
      //SessionFactory should be singleton but it is immutable
      SessionFactory sessionFactory = configuration.buildSessionFactory();
      
      //1. Initialise the session object
      Session session = sessionFactory.openSession();
      
      // Problem with this approach--> null value will be updated in db if we miss to set any field
		/*
		 * Song song = new Song(); song.setId(2);
		 * song.setSongName("Kaata lga - Updated");
		 * 
		 * session.beginTransaction(); session.update(song);
		 * session.getTransaction().commit();
		 */
      
      
      Song song = session.get(Song.class, 2);
      song.setSongName("Kaata lga - Updated");
      
      session.beginTransaction();
      session.update(song);
      session.getTransaction().commit();
      
      session.close();
    }
}
