package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {public boolean saveorupdate(Product product);

public boolean delete(Product product);

public Product get(String id);

public List<Product> getproductC(String id);

public List<Product> list();

public List<Product> getproductPrice();

public List<Product> getproductPrice2();

public List<Product> getproductPrice3();

public List<Product> getproductPro(String Name);



}
