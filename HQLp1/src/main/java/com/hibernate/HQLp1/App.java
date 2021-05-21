package com.hibernate.HQLp1;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);    
        
        SessionFactory sf = config.buildSessionFactory();   
        Session session = sf.openSession();
        
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
        
        
  //     Query q = session.createQuery("from Student");     //(Fetch all student data)
//          Query q = session.createQuery("from Student where marks > 90");      //(it show only that record where marks will be greater than 50)
//          
//        List<Student> students = q.list();
        
       Query q = session.createQuery("from Student where rollno=7");
        Student student = (Student) q.uniqueResult();
        
       System.out.println(student);
        
        
//        for(Student s : students)
//        {
//       	System.out.println(s);
//       }
//        

  
        session.getTransaction().commit();

    }

}