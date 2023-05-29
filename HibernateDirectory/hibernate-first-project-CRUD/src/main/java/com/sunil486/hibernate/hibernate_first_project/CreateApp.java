package com.sunil486.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sunil486.entity.Song;

public class CreateApp 
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
      
      Song song1 = new Song();
      song1.setId(1);
      song1.setSongName("Rim jhim sawan");
      song1.setArtist("Kishore Kumar");
      
      session.beginTransaction();
      session.save(song1);
      session.getTransaction().commit();
      
      System.out.println("song saved....check db");
      
      session.close();
      
      Session session1= sessionFactory.openSession();
      session1.beginTransaction();
      session1.save(new Song(2,"Kaata lga", "Himesh Reshamiya"));
      session1.getTransaction().commit();
      System.out.println("new song saved....check db");
      
      session1.close();
    }
}
