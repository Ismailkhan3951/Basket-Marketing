package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {
	public boolean saveorupdate(User user);
	
	public boolean delete(User user);
	
	public User get(String id);
	
	public List<User> list();
	
	public User isValid(String email,String password);
	
	  public User getUseremail(String email);
}
