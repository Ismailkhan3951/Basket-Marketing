package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.UserDao;
import com.niit.model.User;

@Controller
public class LoginController {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout,Model model){
	if(error!=null)
		model.addAttribute("error","invalid User name or password");
	if(logout!=null)
		model.addAttribute("logout", "login seccessfull");
	return "login";
	}
	
	@RequestMapping(value="/j_spring_security_check")
    public String processRegistration(@RequestParam("j_username")String email,@RequestParam("j_password")String pwd,
   		 Model model,HttpSession session )
    {
		System.out.println("sdfads");
		
		User u=userDao.isValid(email, pwd);
		if(u==null)
		{
			System.out.println("kjhdfskj");
			 model.addAttribute("msg","Invalid user name and password");
	    		return "redirect:/"; 
	    }
		else 
		{
//			 session.setAttribute("user", u);
//    		 session.setAttribute("name",u.getName());
//    		 session.setAttribute("items",u.getCart().getTotal_item());
    		 return "redirect:/"; 
		}
		
		
	}
	
	@RequestMapping(value="/j_spring_security_logout")
	public String logout(HttpServletRequest request, HttpSession Session, Model model){
		Session.invalidate();
		Session =request.getSession(true);
		model.addAttribute("logout", "logout successful");
		return "redirect:/";
	}
	
}
