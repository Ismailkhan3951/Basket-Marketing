package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;
import com.niit.model.User;

public class SupplierTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		SupplierDao supplierDao=(SupplierDao) context.getBean("supplierDao");
		Supplier s=(Supplier) context.getBean("supplier");
		s.setS_id("507");
		s.setS_name("ismail khan");
		s.setS_location("bangalore");
		s.setPh_no("7799333653");
		
		//save and update
		if(supplierDao.saveorupdate(s)==true)
			System.out.println("supplier Saved");
		
		else
			System.out.println("supplier not Saved");
		
		
		s.setS_id("508");
		s.setS_name("abc khan");
		s.setS_location("bangalore");
		s.setPh_no("7799864553");
		
		//save and update
		if(supplierDao.saveorupdate(s)==true)
			System.out.println("supplier Saved");
		
		else
			System.out.println("supplier not Saved");

		//Deleting
		Supplier s1=supplierDao.get("507");
		if(supplierDao.delete(s1)==true)
		{
			System.out.println("Supplier deleted");
		}
			else
			{
				System.out.println("Could not delete");
			}
		
		
		//Retrieving through id
//		s= supplierDao.get("507");
//		if(s==null)
//		{
//			System.out.println("No data found");
//		}
//		else
//		{
//			System.out.println(s.getS_id());
//			System.out.println(s.getS_name());
//			System.out.println(s.getPh_no());
//			System.out.println(s.getS_locaton());
//		
//		}
//		
		
//		//Listing
//		List<Supplier> list= supplierDao.list();
//		for(Supplier s1:list)
//		{
//			System.out.println(s1.getS_id());
//			System.out.println(s1.getS_name());
//			System.out.println(s1.getPh_no());
//			System.out.println(s1.getS_locaton());
//			
//			
//		}
		
		
		
		
	}

}
