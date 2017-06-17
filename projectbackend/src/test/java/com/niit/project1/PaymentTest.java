package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.PaymentDao;
import com.niit.model.Payment;

public class PaymentTest {
	
	public static void main (String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");//scan the package under com.niit
		context.refresh();//refresh and store the instances
		
		PaymentDao paymentDao=(PaymentDao) context.getBean("paymentDao");
		Payment p=(Payment) context.getBean("payment");
		
		
		p.setPayment_id("qwe12");
		p.setPayment_method("card");
		p.setPayment_Status("payment done");
		
		if(paymentDao.saveorupdate(p)==true)
			System.out.println("Payment Saved");
		
		else
			System.out.println("Payment not Saved");
		
		p.setPayment_id("qwe12");
		p.setPayment_method("card");
		p.setPayment_Status("payment done");
		
		if(paymentDao.saveorupdate(p)==true)
			System.out.println("Payment Saved");
		
		else
			System.out.println("Payment not Saved");
		
		
		p.setPayment_id("asd34");
		p.setPayment_method("card");
		p.setPayment_Status("payment done");
		
		if(paymentDao.saveorupdate(p)==true)
			System.out.println("Payment Saved");
		
		else
			System.out.println("Payment not Saved");
		
		
		//Deleting
		p=paymentDao.get("asd34");
		if(paymentDao.delete(p)==true)
		{
			System.out.println("Payment deleted");
		}
			else
			{
				System.out.println("Payment could not delete");
			}
		
		
		//Retrieving through id
		p= paymentDao.get("qwe12");
		if(p==null)
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println(p.getPayment_id());
			System.out.println(p.getPayment_method());
			System.out.println(p.getPayment_Status());
		
			
		}
		
		
		//Listing
		List<Payment> list= paymentDao.list();
		for(Payment p1:list)
		{

			System.out.println(p1.getPayment_id());
			System.out.println(p1.getPayment_method());
			System.out.println(p1.getPayment_Status());
			
		}
		
		}
}
