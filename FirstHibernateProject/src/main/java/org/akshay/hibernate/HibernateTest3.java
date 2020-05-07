package org.akshay.hibernate;

import org.akshay.hibernatex.dto.UserDetails3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest3 {

	public static void main(String[] args) {
		
		 
		UserDetails3 user;
		user=UserDetails3.builder().userName("User Dets").build();
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		user.setUserName("User Dets Updated");
		
		session.getTransaction().commit();
		
		session.close();
		
	}

}
