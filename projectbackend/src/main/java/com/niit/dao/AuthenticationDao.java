package com.niit.dao;

import java.util.List;

import com.niit.model.Authentication;

public interface AuthenticationDao {
public boolean saveorupdate(Authentication authentication);
	
	public boolean delete(String role_Id);
	
	public Authentication get(String role_id);
	
	public List<Authentication> list();

}
