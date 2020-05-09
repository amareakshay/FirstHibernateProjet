package org.akshay.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.akshay.hibernatex.dto.UserDetails3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHqlTest {
	
	public static void main(String args[]) {
		
		String minUserId = "10";
		String userName = "User 10";
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails3");
		Query query1 = session.createQuery("select userName from UserDetails3");
		Query query2 = session.createQuery("from UserDetails3 where userId > :queryId and userName = :queryName");
		query2.setParameter("queryId", Integer.parseInt(minUserId));
		query2.setParameter("queryName", userName);
		// this specifies to start from the index 5
		query1.setFirstResult(5);
		// this specifies to end at index 5
		query1.setMaxResults(5);		
		List<UserDetails3> users = (List<UserDetails3>) query2.getResultList();
		
		List<String> userNames = (List<String>) query1.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		users.forEach(user -> System.out.println(user.toString()));
		
		userNames.forEach(System.out::println);
		
		System.out.println("List Size is : " + users.size());
		
	}

}
