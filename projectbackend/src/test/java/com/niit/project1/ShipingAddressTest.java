package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ShipingAddressDao;
import com.niit.model.ShipingAddress;



public class ShipingAddressTest {
	public static void main (String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		ShipingAddressDao shipingAddressDao=(ShipingAddressDao)context.getBean("shipingAddressDao");
		ShipingAddress ship=(ShipingAddress) context.getBean("shipingAddress");
		
		ship.setShip_id("s123");
		ship.setShip_name("khan");
		ship.setShip_houseno("123-31");
		ship.setShip_streetname("rjnr");
		ship.setShip_city("blr");
		ship.setShip_state("ap");
		ship.setShip_country("India");
		ship.setShip_pincode("533103");
		if(shipingAddressDao.saveorupdate(ship)==true)
			System.out.println("ShipingAddress Saved");
		
		else
			System.out.println("Shiping Address not Saved");
		
		ship.setShip_id("s456");
		ship.setShip_name("smile");
		ship.setShip_houseno("123-31");
		ship.setShip_streetname("rjnr");
		ship.setShip_city("blr");
		ship.setShip_state("ap");
		ship.setShip_country("India");
		ship.setShip_pincode("533103");
		if(shipingAddressDao.saveorupdate(ship)==true)
			System.out.println("ShipingAddress Saved");
		
		else
			System.out.println("ShipingAddress not Saved");
		
		
		
		
		
		//Deleting
//		ship=shipingAddressDao.get("s456");
//		if(shipingAddressDao.delete(ship)==true)
//		{
//			System.out.println("ShipingAddress deleted");
//		}
//			else
//			{
//				System.out.println("Could not delete");
//			}
//		
//		
		//Retrieving through id
		ship= shipingAddressDao.get("s123");
		if(ship==null)
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println(ship.getShip_id());
			System.out.println(ship.getShip_name());
			System.out.println(ship.getShip_houseno());
			System.out.println(ship.getShip_streetname());
			System.out.println(ship.getShip_city());
			System.out.println(ship.getShip_state());
			System.out.println(ship.getShip_country());
			System.out.println(ship.getShip_pincode());
		}
//		
//		
//		//Listing
//		List<BillingAddress> list= billingAddressDao.list();
//		for(BillingAddress b1:list)
//		{
//			System.out.println(b1.getBill_id());
//			System.out.println(b1.getHouse_no());
//			System.out.println(b1.getStreet_name());
//			System.out.println(b1.getCity());
//			System.out.println(b1.getState());
//			System.out.println(b1.getCountry());
//			System.out.println(b1.getPincode());
//		}

	}
}
