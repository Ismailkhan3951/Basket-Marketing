package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {
	public boolean saveorupdate(Category category);
	
	public boolean delete(Category category);
	
	public Category get(String id);
	
	public Category getCategorybypro(String id);
	
	public List<Category> list();


}
