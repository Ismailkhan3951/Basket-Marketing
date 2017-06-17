package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BillingAddressDao;
import com.niit.dao.OrderDao;
import com.niit.dao.PaymentDao;
import com.niit.dao.ShipingAddressDao;
import com.niit.dao.UserDao;
import com.niit.model.BillingAddress;
import com.niit.model.Order;
import com.niit.model.Payment;
import com.niit.model.ShipingAddress;
import com.niit.model.User;

public class OrderTest {
	public static void main (String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");//scan the package under com.niit
		context.refresh();//refresh and store the instances
		
		OrderDao orderDao=(OrderDao) context.getBean("orderDao");
		Order o=(Order) context.getBean("order");
		
		BillingAddressDao billingAddressDao=(BillingAddressDao)context.getBean("billingAddressDao");
		BillingAddress b=(BillingAddress) context.getBean("billingAddress");
		
		ShipingAddressDao shipingAddressDao=(ShipingAddressDao)context.getBean("shipingAddressDao");
		ShipingAddress ship=(ShipingAddress) context.getBean("shipingAddress");
		
		PaymentDao paymentDao=(PaymentDao) context.getBean("paymentDao");
		Payment p=(Payment) context.getBean("payment");
		
		UserDao userDao=(UserDao) context.getBean("userDao");
		User u=(User) context.getBean("user");
		
		u.setUser_id("12508");
		o.setUser(u);
		
		p.setPayment_id("qwe12");
		o.setPayment(p);
		
		ship.setShip_id("s123");
		o.setShipingAddress(ship);
		
		b.setBill_id("a123");
		o.setBillingAddress(b);
		
		o.setOrder_id("1234");
		o.setOrder_date("12-3-17");
		o.setOrder_time("10:45");
		o.setGrand_total(445.0);
		if(orderDao.saveorupdate(o)==true)
			System.out.println("Order Saved");
		
		else
			System.out.println("Order not Saved");
		
		o.setOrder_id("4321");
		o.setOrder_date("09-7-17");
		o.setOrder_time("12:45");
		o.setGrand_total(445.0);
		if(orderDao.saveorupdate(o)==true)
			System.out.println("Order Saved");
		
		else
			System.out.println("Order not Saved");
		
		//Deleting
//		o=orderDao.get("asd34");
//		if(orderDao.delete(o)==true)
//		{
//			System.out.println("Order deleted");
//		}
//			else
//			{
//				System.out.println("Order could not delete");
//			}
		
		
		//Retrieving through id
		o= orderDao.get("qwe12");
		if(o==null)
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println(o.getOrder_id());
			System.out.println(o.getOrder_date());
			System.out.println(o.getOrder_time());
			System.out.println(o.getGrand_total());
			
		}
		
		
		//Listing
		List<Order> list= orderDao.list();
		for(Order o1:list)
		{

			System.out.println(o1.getOrder_id());
			System.out.println(o1.getOrder_date());
			System.out.println(o1.getOrder_time());
			System.out.println(o1.getGrand_total());
			
		}
		
		}


}
