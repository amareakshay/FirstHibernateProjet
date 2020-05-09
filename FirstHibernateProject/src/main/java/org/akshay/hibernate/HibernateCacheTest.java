package org.akshay.hibernate;

import org.akshay.hibernatex.dto.UserDetails3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.extern.slf4j.Slf4j;

public class HibernateCacheTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails3 user = session.get(UserDetails3.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails3 user2 = session2.get(UserDetails3.class, 1);
		
		session2.getTransaction().commit();
		session2.close();
		
		
	}

}
