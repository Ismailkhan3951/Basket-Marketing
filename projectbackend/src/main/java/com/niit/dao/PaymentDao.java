package com.niit.dao;

import java.util.List;

import com.niit.model.Payment;

public interface PaymentDao  {
	public boolean saveorupdate(Payment payment);
	
	public boolean delete(Payment payment);
	
	public Payment get(String id);
	
	public List<Payment> list();

}
