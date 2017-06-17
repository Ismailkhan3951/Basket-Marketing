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
import com.niit.model.Category;
@Controller
public class CategoryController
{
	@Autowired
	Category category;

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/category")
	public ModelAndView category()
	{
		List<Category> categories= categoryDao.list();
		ModelAndView obj=new ModelAndView("category");
		obj.addObject("category", new Category());
		obj.addObject("catogories", categories);
		return obj;
	}

	@RequestMapping(value="/Add_Category", method=RequestMethod.POST)
	public ModelAndView category(@ModelAttribute("category")Category category)
	{
		ModelAndView obj = new ModelAndView("redirect:/category");
		if(categoryDao.saveorupdate(category))
		{
			obj.addObject("msg","\t Scessfully Saved the Category");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Category Please re-try");
		return obj;
	}
	
	@RequestMapping(value="/edit_Category/{Cat_id}")
	public ModelAndView editcategory(@PathVariable("Cat_id")String cat_id)
	{
		List<Category> categories= categoryDao.list();
		ModelAndView obj = new ModelAndView("category");
		category=categoryDao.get(cat_id);
		obj.addObject("catogories", categories);
		obj.addObject("category", category);
		return obj;
	}
	
	@RequestMapping(value="/delete_Category/{Cat_id}")
	public ModelAndView deletecategory(@PathVariable("Cat_id")String cat_id)
	{
		ModelAndView obj = new ModelAndView("redirect:/category");
		category=categoryDao.get(cat_id);
		if(categoryDao.delete(category))
		{
			obj.addObject("msg","\t Scessfully the Category");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Category Please re-try");
		return obj;
	}
}

