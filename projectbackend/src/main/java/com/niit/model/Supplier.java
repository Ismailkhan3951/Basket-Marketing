package com.niit.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")
@Component

public class Supplier {
	public static final long SerialVersionUID=1l;

	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	@Id
	private String S_id;
	private String S_name;
	private String S_location;
	private String Ph_no;
	
	public Supplier()
	{
		this.S_id="sup"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getS_id() {
		return S_id;
	}
	public void setS_id(String s_id) {
		S_id = s_id;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}
	public String getS_location() {
		return S_location;
	}
	public void setS_location(String s_location) {
		S_location = s_location;
	}
	public String getPh_no() {
		return Ph_no;
	}
	public void setPh_no(String ph_no) {
		Ph_no = ph_no;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
