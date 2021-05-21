package com.hibernate.GetLoad;

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
        
//        Laptop l1=new Laptop();
//        l1.setBrand("SONY");
//        l1.setLid(102);
//        l1.setPrice(50000);
//        
//        session.save(l1);
        
        System.out.println("-------------------get------------------\n");
       
        //if u comment sop (obj not used) still it will fire query
        
            Laptop lap = (Laptop) session.get(Laptop.class, 102);
            System.out.println(lap);
            
        System.out.println("-------------------------------------\n");
        
        
        System.out.println("-------------------Load------------------\n");
          //if u comment sop it wont fire query  
             Laptop lap1 = (Laptop) session.load(Laptop.class, 102);      //Proxy object
           System.out.println(lap1);

        System.out.println("-------------------------------------\n");
  
          
          
        session.getTransaction().commit();


    }

}


