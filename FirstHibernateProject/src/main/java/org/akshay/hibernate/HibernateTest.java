package org.akshay.hibernate;

import java.util.Date;

import org.akshay.hibernatex.dto.Address;
import org.akshay.hibernatex.dto.UserDetails;
import org.akshay.hibernatex.dto.UserDetails1;
import org.akshay.hibernatex.dto.UserDetails2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails1 user = new UserDetails1();
		Address homeAddress = new Address();
		Address officeAddress = new Address();
		
		//user.setUserId(1);
		user.setUserName("First User");
		
		  user.setDescription("First User's Description"); 
		  user.setJoinDate(new Date());
		  
		  // set user address details homeAddress.setCity("Leeds");
		  homeAddress.setState("West Yorkshore");
		  homeAddress.setStreet("43 Parkfield Court");
		  homeAddress.setPinCode("LS27 0NR");
		  
		  //Set User Office Address Details officeAddress.setCity("Leeds");
		  officeAddress.setState("West YorkShire");
		  officeAddress.setStreet("1 Capitol House");
		  officeAddress.setPinCode("LS27 0WH");
		 
		
		//Allocate the address to UserDetails
//		user.setHomeAddress(homeAddress);
//		user.setOfficeAddress(officeAddress);
		
		// Set Implementation
		user.getListOfAddresses().add(homeAddress);
		user.getListOfAddresses().add(officeAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		// the below transaction will define our unit of work
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session = sessionFactory.openSession();
		user = session.get(UserDetails1.class, 1);
		
		System.out.println("User id is : " + user.getUserId());
		System.out.println("User Name is : " + user.getUserName());
		
//		user.getListOfAddresses().forEach(address -> System.out.println(address.getPinCode()));
		
		session.close();
		
		
	}
}
