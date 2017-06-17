package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao {
	public boolean saveorupdate(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart get(String id);
	
	public List<Cart> list();
}
