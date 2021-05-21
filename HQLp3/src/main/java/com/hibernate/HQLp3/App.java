package com.hibernate.HQLp3;

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
        
        //Native Queries..
        
        SQLQuery query = session.createSQLQuery("select * from student where marks>60"); 
        query.addEntity(Student.class); 
        List<Student> students = query.list();
        for(Object o : students)
        {  	
        	System.out.println(o);
        }
        
        System.out.println("\n-----------------rollno and marks only---------------\n");
        
        SQLQuery query1 = session.createSQLQuery("select name,marks from student where marks>60"); 
        query1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        List<Student> students1 = query1.list();
        for(Object o : students1)
        {  	
        	Map m = (Map)o;
        	System.out.println(m.get("name") + " : " + m.get("marks"));
        	
        }
        
  
      
        session.getTransaction().commit();
  

    }

}

