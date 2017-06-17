package com.niit.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
@Component
public class Product {
	public static final long SerialVersionUID=1l;

	
	@ManyToOne
	@JoinColumn(name="S_id")
	private Supplier supplier;
	
	@Id
	private String P_id;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	 private Category category;
	
	@Transient
	private MultipartFile pimg;
	
	private String P_name;
	private String P_description;
	private double P_quantity;
	private double P_price;
	
	
	public MultipartFile getPimg() {
		return pimg;
	}
	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}
	public Product()
	{
		this.P_id="prod"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getP_id() {
		return P_id;
	}
	public void setP_id(String p_id) {
		P_id = p_id;
	}
	public String getP_name() {
		return P_name;
	}
	public void setP_name(String p_name) {
		P_name = p_name;
	}
	public String getP_description() {
		return P_description;
	}
	public void setP_description(String p_description) {
		P_description = p_description;
	}
	public double getP_quantity() {
		return P_quantity;
	}
	public void setP_quantity(double p_quantity) {
		P_quantity = p_quantity;
	}
	public double getP_price() {
		return P_price;
	}
	public void setP_price(double p_price) {
		P_price = p_price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
