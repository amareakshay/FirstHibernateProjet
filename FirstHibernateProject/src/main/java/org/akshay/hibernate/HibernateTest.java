package org.akshay.hibernate;

import java.util.Date;

import org.akshay.hibernatex.dto.Address;
import org.akshay.hibernatex.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Address homeAddress = new Address();
		Address officeAddress = new Address();
		
		//user.setUserId(1);
		user.setUserName("First User");
		user.setDescription("First User's Description");
		user.setJoinDate(new Date());
		
		// set user address details
		homeAddress.setCity("Leeds");
		homeAddress.setState("West Yorkshore");
		homeAddress.setStreet("43 Parkfield Court");
		homeAddress.setPinCode("LS27 0NR");
		
		//Set User Office Address Details
		officeAddress.setCity("Leeds");
		officeAddress.setState("West YorkShire");
		officeAddress.setStreet("1 Capitol House");
		officeAddress.setPinCode("LS27 0WH");
		
		//Allocate the address to UserDetails
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		// the below transaction will define our unit of work
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("User id is : " + user.getUserId());
		System.out.println("User Name is : " + user.getUserName());
		
		
	}
}
