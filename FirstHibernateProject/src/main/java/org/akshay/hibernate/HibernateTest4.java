package org.akshay.hibernate;

import org.akshay.hibernatex.dto.UserDetails3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// To Enter Multiple Rows in UserDetails3 class
public class HibernateTest4 {

	public static void main(String[] args) {
		
		 
		UserDetails3 user;

				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for (int i=1;i <=10;i++) {
			user=UserDetails3.builder().userName("User " + i).build();
			session.save(user);
		}
		
		session.getTransaction().commit();
		
		session.close();
	}

}
