package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDao;
import com.niit.model.Cart;
import com.niit.model.CartItems;


public class CartTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CartDao cartDao=(CartDao) context.getBean("cartDao");
		Cart cart=(Cart) context.getBean("cart");		
		
		cart.setCart_Id("1234");
		cart.setTotal_item(3);
		cart.setGrand_total(899.0);
		
		//save and update
		if(cartDao.saveorupdate(cart)==true)
			System.out.println("cart Saved");
		
		else
			System.out.println("cart not Saved");
		
		cart.setCart_Id("A123");
		cart.setTotal_item(2);
		cart.setGrand_total(450.0);
		
		//save and update
		if(cartDao.saveorupdate(cart)==true)
			System.out.println("cart Saved");
		
		else
			System.out.println("cart not Saved");
		
		
		
		//Deleting
		cart=cartDao.get("A123");
		if(cartDao.delete(cart)==true)
		{
			System.out.println("Cart deleted");
		}
			else
			{
				System.out.println("Could not delete");
			}
//		
//		
		
		//Retrieving through id
				cart= cartDao.get("1234");
				if(cart==null)
				{
					System.out.println("No data found");
				}
				else
				{
					System.out.println(cart.getCart_Id());
					System.out.println(cart.getTotal_item());
					System.out.println(cart.getGrand_total());
					
					
				}
				
				
				//Listing
				List<Cart> list= cartDao.list();
				for(Cart c:list)
				{
					System.out.println(cart.getCart_Id());
					System.out.println(cart.getTotal_item());
					System.out.println(cart.getGrand_total());
					
				}
	}

}
