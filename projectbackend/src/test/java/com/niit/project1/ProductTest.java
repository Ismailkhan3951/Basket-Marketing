package com.niit.project1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

public class ProductTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		ProductDao productDao=(ProductDao) context.getBean("productDao");
		Product p=(Product) context.getBean("product");
		
		Category c= (Category)context.getBean("category");
		CategoryDao cDao= (CategoryDao) context.getBean("categoryDao");
		
		Supplier s=(Supplier)context.getBean("supplier");
		SupplierDao sDao=(SupplierDao) context.getBean("supplierDao");
		
		p.setP_id("a123idx");
		p.setP_name("laptop");
		p.setP_price(45000.00);
		p.setP_quantity(1.0);
		p.setP_description("Toshiba Satellite Laptop");
		
		Category cat= cDao.get("123235");
		p.setCategory(cat);
		
		Supplier sup= sDao.get("508");
	    p.setSupplier(sup);
//		//save and update
		if(productDao.saveorupdate(p)==true)
			System.out.println("product Saved");
		
		else
			System.out.println("product not Saved");
		
		
		p.setP_id("507");
		p.setP_name("mobile");
		p.setP_price(45500.00);
		p.setP_quantity(1.0);
		p.setP_description("Iphone");
//		
//		//save and update
		if(productDao.saveorupdate(p)==true)
			System.out.println("product Saved");
		
		else
			System.out.println("product not Saved");
		
		
		
		//Deleting
		Product p1=productDao.get("a123idx");
				if(productDao.delete(p1)==true)
				{
					System.out.println("Product deleted");
				}
					else
					{
						System.out.println("Product not delete");
					}
				//Retrieving through id
				p= productDao.get("507");
				if(p==null)
				{
					System.out.println("No data found");
				}
				else
				{
					System.out.println(p.getP_id());
					System.out.println(p.getP_name());
					System.out.println(p.getP_description());
					System.out.println(p.getP_price());
					System.out.println(p.getP_quantity());
				}
				
				
				//Listing
				List<Product> list = productDao.list();
				for(Product p2:list)
				{
					System.out.println(p2.getP_id());
					System.out.println(p2.getP_name());
					System.out.println(p2.getP_description());
					System.out.println(p2.getP_price());
					System.out.println(p2.getP_quantity());
				}
						
				
				
				
				
				
	}

}
