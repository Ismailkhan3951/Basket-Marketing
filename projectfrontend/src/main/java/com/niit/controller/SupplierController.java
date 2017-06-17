package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDao;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	
	
		@Autowired
		Supplier supplier;

		@Autowired
		SupplierDao supplierDao;
		
		@RequestMapping("/supplier")
		public ModelAndView supplier()
		{
			List<Supplier> suppliers = supplierDao.list();
			ModelAndView obj=new ModelAndView("supplier");
			obj.addObject("supplier", new Supplier());
			obj.addObject("suppliers",suppliers);
			return obj;
		}

		@RequestMapping(value="/Add_Supplier", method=RequestMethod.POST)
		public ModelAndView category(@ModelAttribute("supplier")Supplier supplier)
		{
			ModelAndView obj = new ModelAndView("redirect:/supplier");
			if(supplierDao.saveorupdate(supplier))
			{
				obj.addObject("msg","\t Scessfully Saved the Supplier");
			}
			else
				obj.addObject("msg","\t Sorry!  Failed to Save the Supplier Please re-try");
			return obj;
		}
			@RequestMapping(value="/edit_Supplier/{S_id}")
			public ModelAndView editsupplier(@PathVariable("S_id")String s_id)
			{
				List<Supplier> suppliers= supplierDao.list();
				ModelAndView obj = new ModelAndView("supplier");
				supplier=supplierDao.get(s_id);
				obj.addObject("suppliers", suppliers);
				obj.addObject("supplier", supplier);
				return obj;
			}
			
			@RequestMapping(value="/delete_Supplier/{S_id}")
			public ModelAndView deletesupplier(@PathVariable("S_id")String s_id)
			{
				ModelAndView obj = new ModelAndView("redirect:/supplier");
				supplier=supplierDao.get(s_id);
				if(supplierDao.delete(supplier))
				{
					obj.addObject("msg","\t Scessfully the Supplier");
				}
				else
					obj.addObject("msg","\t Sorry!  Failed to Save the Supplier Please re-try");
				return obj;
		}
}
