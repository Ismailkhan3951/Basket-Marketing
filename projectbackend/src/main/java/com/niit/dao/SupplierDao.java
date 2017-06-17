package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;


public interface SupplierDao {
	public boolean saveorupdate(Supplier supplier);
	
	public boolean delete(Supplier supplier);
	
	public Supplier get(String id);
	
	public List<Supplier> list();


}
