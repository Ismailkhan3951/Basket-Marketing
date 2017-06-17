package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BillingAddressDao;
import com.niit.model.BillingAddress;


public class BillingAddressTest {
	public static void main (String[] args){
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		BillingAddressDao billingAddressDao=(BillingAddressDao)context.getBean("billingAddressDao");
		BillingAddress b=(BillingAddress) context.getBean("billingAddress");
		
		b.setBill_id("a123");
		b.setHouse_no("79-123");
		b.setStreet_name("niit");
		
		b.setCity("bangalore");
		b.setState("karnataka");
		b.setPincode("560008");
		if(billingAddressDao.saveorupdate(b)==true)
			System.out.println("BillingAddress Saved");
		
		else
			System.out.println("BillingAddress not Saved");
		
		
		b.setBill_id("q456");
		b.setHouse_no("89-456");
		b.setStreet_name("rjnr");
		b.setCity("bangalore");
		b.setState("karnataka");
		b.setCountry("India");
		b.setPincode("560008");
		if(billingAddressDao.saveorupdate(b)==true)
			System.out.println("BillingAddress Saved");
		
		else
			System.out.println("BillingAddress not Saved");
		
		
//		//Deleting
//		b=billingAddressDao.get("q456");
//		if(billingAddressDao.delete(b)==true)
//		{
//			System.out.println("BillingAddress deleted");
//		}
//			else
//			{
//				System.out.println("Could not delete");
//			}
//		
//		
		//Retrieving through id
		b= billingAddressDao.get("a123");
		if(b==null)
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println(b.getBill_id());
			System.out.println(b.getHouse_no());
			System.out.println(b.getStreet_name());
			System.out.println(b.getCity());
			System.out.println(b.getState());
			System.out.println(b.getCountry());
			System.out.println(b.getPincode());
			
		}
//		
//		
//		//Listing
		List<BillingAddress> list= billingAddressDao.list();
		for(BillingAddress b1:list)
		{
			System.out.println(b1.getBill_id());
			System.out.println(b1.getHouse_no());
			System.out.println(b1.getStreet_name());
			System.out.println(b1.getCity());
			System.out.println(b1.getState());
			System.out.println(b1.getCountry());
			System.out.println(b1.getPincode());
		}
		context.close();
		}

}
