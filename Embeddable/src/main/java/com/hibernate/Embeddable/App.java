package com.hibernate.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Embeddable.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		User u1 = new User();
		u1.setAge(25);
		u1.setId(101);
		Name n1 = new Name();
		n1.setFname("naveen");
		n1.setMname("V");
		n1.setLname("E");
		u1.setName(n1);

		Configuration con = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Name.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(u1);

		//User u2 = null;

		//u2 = (User) session.get(User.class, 101);

		tx.commit();

		//System.out.println(u2);
	}
}