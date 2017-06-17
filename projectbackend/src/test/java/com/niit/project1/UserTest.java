package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BillingAddressDao;
import com.niit.dao.CartDao;
import com.niit.dao.UserDao;
import com.niit.model.BillingAddress;
import com.niit.model.Cart;
import com.niit.model.User;

public class UserTest {
	public static void main (String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");//scan the package under com.niit
		context.refresh();//refresh and store the instances
		
		UserDao userDao=(UserDao) context.getBean("userDao");
		User u=(User) context.getBean("user");
		// cart and billing mapping has to done
		CartDao cartDao=(CartDao) context.getBean("cartDao");
		Cart cart=(Cart) context.getBean("cart");
		
		BillingAddressDao billingAddressDao=(BillingAddressDao)context.getBean("billingAddressDao");
		BillingAddress b=(BillingAddress) context.getBean("billingAddress");
		
		u.setUser_id("12508");
		u.setName("Roshsdf");
		u.setPassword("12334");
		u.setDob("15-12-1993");
		u.setPh_no("9848452338");
		u.setEmail_id("rosrsn@gmail.com");
		u.setCity("bangalore");
		u.setCountry("India");
		u.setLocation("gfj");
		u.setBillingAddress(b);
		u.setCart(cart);
		if(userDao.saveorupdate(u)==true)
			System.out.println("user Saved");
		
		else
			System.out.println("user not Saved");
		
		u.setUser_id("123");
		u.setName("abc");
		u.setPassword("123");
		u.setDob("15-12-1993");
		u.setPh_no("9848338");
		u.setEmail_id("asdfn@gmail.com");
		
		if(userDao.saveorupdate(u)==true)
			System.out.println("user Saved");
		
		else
			System.out.println("user not Saved");
		
		
		u.setUser_id("12532");
		u.setName("Rofsff");
		u.setPassword("3334");
		u.setDob("15-12-1996");
		u.setPh_no("984342338");
		u.setEmail_id("ewrrsn@gmail.com");
//		save and update
		if(userDao.saveorupdate(u)==true)
			System.out.println("user Saved");
		
		else
			System.out.println("user not Saved");
		
		//Deleting
//		u=userDao.get("12508");
//		if(userDao.delete(u)==true)
//		{
//			System.out.println("User deleted");
//		}
//			else
//			{
//				System.out.println("Could not delete");
//			}
		
		
		//Retrieving through id
		u= userDao.get("12532");
		if(u==null)
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println(u.getUser_id());
			System.out.println(u.getName());
			System.out.println(u.getDob());
			System.out.println(u.getEmail_id());
			System.out.println(u.getPassword());
			System.out.println(u.getPh_no());
			
		}
		
		
		//Listing
		List<User> list= userDao.list();
		for(User u1:list)
		{
			System.out.println(u1.getUser_id());
			System.out.println(u1.getDob());
			System.out.println(u1.getEmail_id());
			System.out.println(u1.getName());
			System.out.println(u1.getPassword());
			System.out.println(u1.getPh_no());
		}
		
		}
	}
	



