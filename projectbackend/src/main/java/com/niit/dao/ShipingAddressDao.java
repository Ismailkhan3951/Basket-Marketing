package com.niit.dao;

import java.util.List;


import com.niit.model.ShipingAddress;
import com.niit.model.User;



public interface ShipingAddressDao {
public boolean saveorupdate(ShipingAddress shipingAddress);
	
	public boolean delete(ShipingAddress ShipingAddress);
	
	public ShipingAddress get(String id);
	
	 public User getUseremail(String email);
	 
	 public List<ShipingAddress> getaddbyuser(String u_id);
	 
	  public List<ShipingAddress> list();
}
