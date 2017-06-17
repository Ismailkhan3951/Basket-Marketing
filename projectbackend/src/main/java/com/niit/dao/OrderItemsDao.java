package com.niit.dao;

import java.util.List;


import com.niit.model.OrderItems;

public interface OrderItemsDao {
public boolean saveorupdate(OrderItems orderitems);
	
	public boolean delete(OrderItems  orderitems);
	
	public OrderItems get(String id);
	
	public List<OrderItems> getOrderItemsbyOrder(String order_id);
	
	public List<OrderItems> list();


}
