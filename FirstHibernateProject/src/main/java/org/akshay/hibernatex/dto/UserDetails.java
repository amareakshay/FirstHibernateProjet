package org.akshay.hibernatex.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class UserDetails { 
	
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
	
	/*
	 * @Embedded annotation tells that this is an embedded object, its not mandatory
	 */
	@Embedded
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street", column=@Column(name="OFFICE_STREET")),
	@AttributeOverride(name="city", column=@Column(name="OFFICE_CITY")),
	@AttributeOverride(name="state", column=@Column(name="OFFICE_STATE")),
	@AttributeOverride(name="pinCode", column=@Column(name="OFFICE_PIN_CODE"))})
	private Address officeAddress;

	// The below annotation will tell hibernate to ignore the field while performing database operations
	@Transient
	private String description;
	
	public Date getJoinDate() {
		return joinDate;
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
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address address) {
		this.homeAddress = address;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

}
