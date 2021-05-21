package com.hibernate.ObjectLifeCycle;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;


public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();   
        Session session = sf.openSession();
        
        session.beginTransaction();
        //<transient>
       Laptop l = new Laptop();
       l.setLid(56);
       l.setBrand("lenovo");
       l.setPrice(300);
      //</transient>
        
        //<persistant>
       // session.save(l);
       // l.setPrice(850);
      //</persistant>
        
        Laptop l1=session.get(Laptop.class, 56);
        System.out.println(l1);
        
       //<Removed>
      // session.remove(l1);
     //</Removed>
       
        session.getTransaction().commit();
        
        //<Detached>
        //session.detach(l);
        // l.setPrice(600);
      //</Detached>

  

    }

}