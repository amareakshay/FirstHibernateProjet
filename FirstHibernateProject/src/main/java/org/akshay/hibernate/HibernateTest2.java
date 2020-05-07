package org.akshay.hibernate;

import org.akshay.hibernatex.dto.FourWheeler;
import org.akshay.hibernatex.dto.TwoWheeler;
import org.akshay.hibernatex.dto.UserDetails2;
import org.akshay.hibernatex.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest2 {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		TwoWheeler bike = new TwoWheeler();
		FourWheeler car = new FourWheeler();
		
		vehicle.setVehicleName("Car");
		bike.setVehicleName("Yamaha FZ");
		bike.setSteeringHandle("FZ Steering Hande");
		car.setVehicleName("Tata Nexon");
		car.setSteeringWheel("Nexon Steering Wheel");
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		// the below transaction will define our unit of work
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
	}

}
