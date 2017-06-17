package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CardDao;
import com.niit.model.Card;

public class CardTest {
	public static void main (String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");//scan the package under com.niit
		context.refresh();//refresh and store the instances
		CardDao cardDao=(CardDao) context.getBean("cardDao");
		Card c=(Card) context.getBean("card");
		
		
		c.setCard_id("456");
		c.setCard_no("a123");
		c.setHolder_name("khan");
		c.setExp_date("12/22");
		if(cardDao.saveorupdate(c)==true)
			System.out.println("Card Saved");
		
		else
			System.out.println("Card not Saved");
		
		c.setCard_id("123");
		c.setCard_no("8989");
		c.setHolder_name("smile");
		c.setExp_date("12/33");
		if(cardDao.saveorupdate(c)==true)
			System.out.println("Card Saved");
		
		else
			System.out.println("Card not Saved");
				
		//Deleting
		c=cardDao.get("123");
		if(cardDao.delete(c)==true)
		{
			System.out.println("Card deleted");
		}
			else
			{
				System.out.println("Card could not delete");
			}
		
		
		//Retrieving through id
		c= cardDao.get("456");
		if(c==null)
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println(c.getCard_id());
			System.out.println(c.getCard_no());
			System.out.println(c.getHolder_name());
			System.out.println(c.getExp_date());
			
		}
		
		
		//Listing
		List<Card> list= cardDao.list();
		for(Card c1:list)
		{

			System.out.println(c1.getCard_id());
			System.out.println(c1.getCard_no());
			System.out.println(c1.getHolder_name());
			System.out.println(c1.getExp_date());
			
		}
		
		}

}
