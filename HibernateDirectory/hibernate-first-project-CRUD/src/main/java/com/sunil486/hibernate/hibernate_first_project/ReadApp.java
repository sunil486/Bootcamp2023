package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sunil486.entity.Song;

public class ReadApp 
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
      
      session.beginTransaction();
      //Song song = session.get(Song.class, 2);
      Song song = session.load(Song.class, 2);
      session.getTransaction().commit();
      
      System.out.println("Getting data for id 2 : " + song);
      
      session.close();
    }
}
