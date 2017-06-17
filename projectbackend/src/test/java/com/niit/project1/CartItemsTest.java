package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDao;
import com.niit.dao.CartItemsDao;
import com.niit.dao.ProductDao;
import com.niit.model.Cart;
import com.niit.model.CartItems;
import com.niit.model.Product;

public class CartItemsTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CartItemsDao cartitemsDao=(CartItemsDao) context.getBean("cartItemsDao");
		CartItems c=(CartItems) context.getBean("cartItems");
		
		CartDao cartDao=(CartDao) context.getBean("cartDao");
		Cart cart=(Cart) context.getBean("cart");
		
		Product p=(Product) context.getBean("product");
		ProductDao productDao=(ProductDao) context.getBean("productDao");
		
		c.setCartItems_id("q12");
		c.setPrice(908);
		cart=cartDao.get("1234");
		c.setCart(cart);
		Product product=productDao.get("507");
	//	c.setProduct(product);
		
//		
//		
//		//save and update
		if(cartitemsDao.saveorupdate(c)==true)
		{
			System.out.println("CartItems Saved");
		}
		else{
			System.out.println("CartItems not Saved");
		}

//		CartItems c1=cartitemsDao.get("a123idx");
//				if(cartitemsDao.delete(c1)==true)
//				{
//					System.out.println("CartItems deleted");
//				}
//					else
//					{
//						System.out.println("CartItems not delete");
//					}
				//Retrieving through id
				c= cartitemsDao.get("507");
				if(c==null)
				{
					System.out.println("No data found");
				}
				else
				{
					System.out.println(c.getCartItems_id());
					System.out.println(c.getPrice());
				}
				
				
				//Listing
				List<CartItems> list = cartitemsDao.list();
				for(CartItems c2:list)
				{
					System.out.println(c2.getCartItems_id());
					System.out.println(c2.getPrice());	
				}
	}		

}
