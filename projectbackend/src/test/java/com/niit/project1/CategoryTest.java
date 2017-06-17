package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;
import com.niit.model.User;



public class CategoryTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CategoryDao categoryDao=(CategoryDao) context.getBean("categoryDao");
		Category c=(Category) context.getBean("category");
		
		c.setCat_id("123235");
		c.setCat_name("laptops");
		//save and update
		if(categoryDao.saveorupdate(c)==true)
			System.out.println("category Saved");
		
		else
			System.out.println("category not Saved");
		
		
		c.setCat_id("15");
		c.setCat_name("mobiles");
		//save and update
		if(categoryDao.saveorupdate(c)==true)
			System.out.println("category Saved");
		
		else
			System.out.println("category not Saved");
		
		
		//Deleting
		c=categoryDao.get("15");
		if(categoryDao.delete(c)==true)
		{
			System.out.println("Category deleted");
		}
			else
			{
				System.out.println("Could not delete");
			}
//		
//		
		
		//Retrieving through id
				c= categoryDao.get("123235");
				if(c==null)
				{
					System.out.println("No data found");
				}
				else
				{
					System.out.println(c.getCat_id());
					System.out.println(c.getCat_name());
					
					
				}
				
				
				//Listing
				List<Category> list= categoryDao.list();
				for(Category c1:list)
				{
					System.out.println(c1.getCat_id());
					System.out.println(c1.getCat_name());
				
				}
		
		
	}
}
