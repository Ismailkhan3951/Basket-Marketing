package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDao;
import com.niit.model.User;

@Controller
public class UserController {
	
	
		
		
			@Autowired
			User user;

			@Autowired
			UserDao userDao;
			
//			@RequestMapping("/signup")
//			public String signup()
//			{
//				return "signup";
//			}
			@RequestMapping("/signup")
			public ModelAndView user()
			{
				ModelAndView obj=new ModelAndView("signup");
				obj.addObject("user", new User());
				return obj;
			}

			@RequestMapping(value="/Add_User", method=RequestMethod.POST)
			public ModelAndView user(@ModelAttribute("user")User user)
			{
				ModelAndView obj = new ModelAndView("redirect:/signup");
				if(userDao.saveorupdate(user))
				{
					obj.addObject("msg","\t Scessfully Saved the User");
				}
				else
					obj.addObject("msg","\t Sorry!  Failed to Save the User Please re-try");
			
				return obj;
}
}
