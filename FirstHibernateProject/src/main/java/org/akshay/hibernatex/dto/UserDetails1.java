package org.akshay.hibernatex.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetails1 { 
	
	// name tells Hibernate that it should use the value specified in the name for naming the column
	// Default is the variable name, i.e the column will be named as "userId" had we not specified the 
	// @Column (name="USER_ID") annotation
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE)
	@Column (name="USER_ID")
	private int userId;
	
	@Column (name="USER_NAME")
	
	private String userName;
	// Below annotation will tell hibernate we need only the date and not the timestamp
	@Temporal (TemporalType.DATE)
	private Date joinDate;
	
	@ElementCollection
	@JoinTable(name="User_addresses",joinColumns=@JoinColumn(name="USER_ID"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	// The below annotation will tell hibernate to ignore the field while performing database operations
	@Transient
	private String description;

	public Date getJoinDate() {
		return joinDate;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
