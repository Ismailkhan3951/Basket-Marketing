package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.fileinput.FileInput;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController
{
	@Autowired
	Product product;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	String path="D:\\Eclipse Workspace\\projectfrontend\\src\\main\\webapp\\resource\\images\\";
	
	@RequestMapping("/product")
	public ModelAndView product()
	{
		List<Product> products= productDao.list();
		List<Category> categories = categoryDao.list();
		List<Supplier> suppliers = supplierDao.list();
		ModelAndView obj=new ModelAndView("product");
		obj.addObject("product", new Product());
		obj.addObject("products", products);
		obj.addObject("categories",categories);
		obj.addObject("suppliers",suppliers);
		
        return obj;
	}

	@RequestMapping(value="/Add_Product", method=RequestMethod.POST)
	public ModelAndView product(@ModelAttribute("product")Product product)
	{
		ModelAndView obj = new ModelAndView("redirect:/product");
		
		if(productDao.saveorupdate(product)==true)
		{
			FileInput.upload(path, product.getPimg(), product.getP_id()+".jpg");
			obj.addObject("msg","\t Scessfully Saved the Product");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Product Please re-try");
		return obj;
	}		
		@RequestMapping(value="/edit_Product/{P_id}")
		public ModelAndView editproduct(@PathVariable("P_id")String p_id)
		{
			List<Product> products= productDao.list();
			ModelAndView obj = new ModelAndView("product");
			product=productDao.get(p_id);
			obj.addObject("products", products);
			obj.addObject("product", product);
			return obj;
		}
		
		@RequestMapping(value="/delete_Product/{P_id}")
		public ModelAndView deleteproduct(@PathVariable("P_id")String p_id)
		{
			ModelAndView obj = new ModelAndView("redirect:/product");
			product=productDao.get(p_id);
			if(productDao.delete(product))
			{
				obj.addObject("msg","\t Scessfully the product");
			}
			else
				obj.addObject("msg","\t Sorry!  Failed to Save the product Please re-try");
			return obj;
}
}	
	
