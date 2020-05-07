package org.akshay.hibernate;

import org.akshay.hibernatex.dto.UserDetails2;
import org.akshay.hibernatex.dto.Vehical;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest1 {

	public static void main(String[] args) {
		UserDetails2 user = new UserDetails2();
		Vehical vehical1 = new Vehical();
		Vehical vehical2 = new Vehical();

		user.setUserName("First User");
		vehical1.setVehicalName("Car");
		vehical2.setVehicalName("Motorcycle");
		
		user.getVehicals().add(vehical1);
		user.getVehicals().add(vehical2);
		
		vehical1.getUsers().add(user);
		vehical2.getUsers().add(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		// the below transaction will define our unit of work
		session.beginTransaction();
		session.save(user);
		session.save(vehical1);
		session.save(vehical2);
		session.getTransaction().commit();
		session.close();
		
	}

}
