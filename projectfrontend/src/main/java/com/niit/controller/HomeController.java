package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Controller
public class HomeController {
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	@RequestMapping("/all_Products")
	public String Allproducts(Model model)
	{
		List<Product> products=productDao.list();
		model.addAttribute("products",products);
		return "Allproducts";
	
	}
	
	@RequestMapping("/product1")
	public String product()
	{
		return "product1";
	}
	@RequestMapping("/product2")
	public String product2()
	{
		return "product2";
	}
	@RequestMapping("/product3")
	public String product3()
	{
		return "product3";
	}
	@RequestMapping("/product4")
	public String product4()
	{
		return "product4";
	}
	@RequestMapping("/product5")
	public String product5()
	{
		return "product5";
	}
	
//	@RequestMapping("/login")
//	public String login()
//	{
//		return "login";
//	}

//	@RequestMapping("/product")
//	public String product()
//	{
//		return "product";
//	}
//	@RequestMapping("/signup")
//	public String signup()
//	{
//		return "signup";
//	}
//	@RequestMapping("/supplier")
//	public String supplier()
//	{
//		return "supplier";
//	}
}



