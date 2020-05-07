package org.akshay.hibernatex.dto;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name="User_Details")
public class UserDetails2 { 
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	
	@Column (name="USER_NAME")
	private String userName;
	
	@ManyToMany(mappedBy="users")
	//@JoinTable(joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="VEHICAL_ID"))
	private Collection<Vehical> vehicals = new ArrayList<Vehical>();

	public Collection<Vehical> getVehicals() {
		return vehicals;
	}
	public void setVehicals(Collection<Vehical> vehicals) {
		this.vehicals = vehicals;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}