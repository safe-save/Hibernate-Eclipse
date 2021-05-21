package com.hibernate.HQLp2;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class App 
{
    @SuppressWarnings("rawtypes")
	public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);    
       
        SessionFactory sf = config.buildSessionFactory();   
        Session session = sf.openSession();
        int b = 60;
        
        session.beginTransaction();
        
//        Random r = new Random();
//        
//        
//        for(int i=1;i<=50;i++)
//        {
//        	Student s = new Student();
//       	s.setRollno(i);
//       	s.setName("Name" + i);
//       	s.setMarks(r.nextInt(100));
//       	session.save(s);
//       }
        
        
        
 //       Query q = session.createQuery("select rollno,name,marks from Student where rollno=7");
//        Query q = session.createQuery("select rollno,name,marks from Student");
         Query q = session.createQuery("select sum(marks) from Student s where s.marks> :b");
         q.setParameter("b", b);
//          
		Long marks = (Long) q.uniqueResult();
        
//        for(Object o : student)
//        {
//        	System.out.println(o);
//        }
        
       
       System.out.println(marks);
  
        session.getTransaction().commit();
  

    }

}

