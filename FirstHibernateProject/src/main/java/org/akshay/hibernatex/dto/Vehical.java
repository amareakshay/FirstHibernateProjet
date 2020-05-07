package org.akshay.hibernatex.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehical {
	
	@Id @GeneratedValue
	private int vehicalId;
	private String vehicalName;
	@ManyToMany
	private Collection<UserDetails2>  users = new ArrayList<UserDetails2>();
	
	public Collection<UserDetails2> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetails2> users) {
		this.users = users;
	}
	public void setVehicalId(int vehicalId) {
		this.vehicalId = vehicalId;
	}
	public String getVehicalName() {
		return vehicalName;
	}
	public void setVehicalName(String vehicalName) {
		this.vehicalName = vehicalName;
	}

}
