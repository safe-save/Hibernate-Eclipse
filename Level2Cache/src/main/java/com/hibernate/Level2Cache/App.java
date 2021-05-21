package com.hibernate.Level2Cache;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App 
{
    public static void main( String[] args )
    {
    	//Alien a = new Alien();
    	//a.setAid(100);
    	//a.setAname("alien1");
    	//a.setColor("black");
    	
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);    
      
        SessionFactory sf = con.buildSessionFactory();   
        Session session1 = sf.openSession();
        session1.beginTransaction();
        
        //session1.save(a);
        
        Alien a=null;
        
        System.out.println("-----------------------session 1 fetching once using level 2 caching query hits database since first time -----------------------------------------");
  
        Query q1 = session1.createQuery("from Alien where aid=100");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        
        
        session1.getTransaction().commit();
        session1.close();
        
        System.out.println("-----------------------session 2 fetching once using level 2 caching query does not hits database since its there in level2 cache -----------------------------------------");
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        Query q2 = session2.createQuery("from Alien where aid=100");
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        
        session2.getTransaction().commit();
        session2.close();
        


    }
}
