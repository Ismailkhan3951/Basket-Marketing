package com.niit.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class BillingAddress {
	@Id
	private String Bill_id;
	private String House_no;
	private String Street_name;
	private String City;
	private String State;
	private String Pincode;
	private String Country;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="User_id")
	 User user;
	
	  public BillingAddress() {

			this.Bill_id ="BILL"+UUID.randomUUID().toString().toString().substring(30).toUpperCase();
		}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBill_id() {
		return Bill_id;
	}
	public void setBill_id(String bill_id) {
		Bill_id = bill_id;
	}
	public String getHouse_no() {
		return House_no;
	}
	public void setHouse_no(String house_no) {
		House_no = house_no;
	}
	public String getStreet_name() {
		return Street_name;
	}
	public void setStreet_name(String street_name) {
		Street_name = street_name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	

}
