package org.akshay.hibernatex.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="ADDR_STREET")
	private String street;
	@Column(name="ADDR_CITY")
	private String city;
	@Column(name="ADDR_STATE")
	private String state;
	@Column(name="ADDR_PIN_CODE")
	private String pinCode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	

}
