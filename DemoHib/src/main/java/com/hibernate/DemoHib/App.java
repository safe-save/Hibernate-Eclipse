package com.hibernate.DemoHib;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Student s1 = new Student();
       s1.setUsn("1SI15EC054");
       s1.setName("Joe");
       s1.setSem(6);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(s1);
        
        Student s2 = null;
        
        s2 = (Student) session.get(Student.class, "1SI16EC053");
        
        tx.commit();
        
       System.out.println(s2);
    }
}