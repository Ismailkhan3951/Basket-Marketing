package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderDao;
import com.niit.dao.OrderItemsDao;
import com.niit.model.Order;
import com.niit.model.OrderItems;



public class OrderItemsTest {
	public static void main (String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");//scan the package under com.niit
		context.refresh();//refresh and store the instances
		
		OrderItemsDao orderitemsDao=(OrderItemsDao) context.getBean("orderItemsDao");
		OrderItems o=(OrderItems) context.getBean("orderItems");
		//Order Mapping has to done
		OrderDao orderDao=(OrderDao) context.getBean("orderDao");
		Order order=(Order) context.getBean("order");
		
		Order order1=orderDao.get("1234");
		
		o.setOrderItem_id("apple");
		o.setP_id("A123");
		o.setOrder(order1);

		
		if(orderitemsDao.saveorupdate(o)==true)
			System.out.println("orderitems Saved");
		
		else
			System.out.println("OrderItems not Saved");
		
		order1=orderDao.get("23214");

		o.setOrderItem_id("mango");
		o.setP_id("A123");
		o.setOrder(order1);
		
		if(orderitemsDao.saveorupdate(o)==true)
			System.out.println("orderitems Saved");
		
		else
			System.out.println("OrderItems not Saved");
		
		
		//Deleting
		o=orderitemsDao.get("mango");
		if(orderitemsDao.delete(o)==true)
		{
			System.out.println("OrderItems deleted");
		}
			else
			{
				System.out.println("OrderItems could not delete");
			}
		
		
		//Retrieving through id
		o= orderitemsDao.get("apple");
		if(o==null)
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println(o.getOrderItem_id());
			System.out.println(o.getP_id());
			
		
			
		}
		
		
		//Listing
		List<OrderItems> list= orderitemsDao.list();
		for(OrderItems o1:list)
		{

			System.out.println(o.getOrderItem_id());
			System.out.println(o.getP_id());
			
		}
}
}