package com.niit.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")
@Component

public class Category {
	private static final long SerialVersionUID=1l;
	@OneToMany(mappedBy="category")
	private List<Product> product;
	
	@Id
	private String Cat_id;
	private String Cat_name;
	
	public Category()
	{
		this.Cat_id="cat"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCat_id() {
		return Cat_id;
	}
	public void setCat_id(String cat_id) {
		Cat_id = cat_id;
	}
	public String getCat_name() {
		return Cat_name;
	}
	public void setCat_name(String cat_name) {
		Cat_name = cat_name;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
