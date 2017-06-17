package com.niit.dao;

import java.util.List;

import com.niit.model.Card;

public interface CardDao {
public boolean saveorupdate(Card card);
	
	public boolean delete(Card card);
	
	public Card get(String id);
	
	public List<Card> getcardbyuser(String u_Id);
	
	public List<Card> list();

}
