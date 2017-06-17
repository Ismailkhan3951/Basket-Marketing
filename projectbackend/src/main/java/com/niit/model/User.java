package com.niit.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="User")
@Component

public class User 
{
	public static final long SerialVersionUID=1l;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name ="Bill_id")
	private BillingAddress billingAddress;

	@OneToOne
	@JoinColumn(name ="Cart_Id")
	private Cart cart;

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Id
	private String User_id;
	private String Name;
	private String Password;
	private String Ph_no;
	private String email_id;
	private String Dob;
	private String Role="ROLE_USER";
	private String city;
	private String country;
	private String location;
	
	private static final DateFormat sdf= new SimpleDateFormat("dd/MM/YYY");
	public User()
	{
		this.User_id="user"+UUID.randomUUID().toString().substring(30).toUpperCase();
		Date date= new Date();
		Dob =sdf.format(date);
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPh_no() {
		return Ph_no;
	}
	public void setPh_no(String ph_no) {
		Ph_no = ph_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	public static DateFormat getSdf() {
		return sdf;
	}
	
	
}
