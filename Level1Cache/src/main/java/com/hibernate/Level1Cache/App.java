package com.hibernate.Level1Cache;

import java.util.Collection;

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
  
        System.out.println("-----------------------session 1 fetching twice using caching-----------------------------------------");
        
        //session1.save(a);
        Alien a=null;
        
        a = (Alien) session1.get(Alien.class, 100);
        System.out.println(a);
        
        a = (Alien) session1.get(Alien.class, 100);
        System.out.println(a);
        
        
        session1.getTransaction().commit();
       session1.close();
       
       System.out.println("-----------------------session 1 end-----------------------------------------\n");
        
       
       System.out.println("-----------------------session 2 fetching once now its a diffrent cache-----------------------------------------");
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        a = (Alien) session2.get(Alien.class, 100);
       System.out.println(a);
        
        session2.getTransaction().commit();
       session2.close();
       
       System.out.println("-----------------------session 2 end-----------------------------------------\n");
        


    }
}