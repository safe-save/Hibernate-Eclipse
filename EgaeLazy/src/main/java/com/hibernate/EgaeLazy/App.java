package com.hibernate.EgaeLazy;

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
    	Laptop laptop = new Laptop();
    	laptop.setLid(540);
    	laptop.setBrand("SONY");
    	laptop.setPrice("65000");
    	
        Alien s = new Alien();
        s.setAid(120);
        s.setAname("Root");
        s.getLaps().add(laptop);
        
        laptop.setAlien(s);
    	
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);    
        SessionFactory sf = config.buildSessionFactory();   
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        session.save(laptop);
        session.save(s);
        
        Alien a1 = session.get(Alien.class, 48);
        
        System.out.println(a1);
//        Collection<Laptop> laps = a1.getLaps();
//        
//        for(Laptop l : laps)
//        {
//        	System.out.println(l);
//        }

        session.getTransaction().commit();
    }
}


