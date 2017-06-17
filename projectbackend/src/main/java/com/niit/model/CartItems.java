package com.niit.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class CartItems {
	private static final long SerialVersionUID=1l;
	@Id
	private String CartItems_id;
	private double price;

	public CartItems() {
		
		this.CartItems_id ="CIEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@ManyToOne
	@JoinColumn(name="Cart_Id")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="P_id")
	private Product product;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getCartItems_id() {
		return CartItems_id;
	}
	public void setCartItems_id(String cartItems_id) {
		CartItems_id = cartItems_id;
	}
	

}
