package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.CartItemsDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.model.Cart;
import com.niit.model.CartItems;
import com.niit.model.Product;
import com.niit.model.User;

@Controller
public class CartController {
	@Autowired 
	User user;
	@Autowired 
	UserDao userDao;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	
	@Autowired
	Product product;
	@Autowired 
	ProductDao productDao;
	
	@Autowired
	HttpSession session;
	
	
//	@RequestMapping("/addtocartC/{id}")
//	public ModelAndView cart(@PathVariable("id") String id) {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			String currusername = authentication.getName();
//			User u = userDao.getUseremail(currusername);
//			if (user == null) {
//				return new ModelAndView("redirect:/");
//			} else {
//
//				cart = u.getCart();
//				product = productDao.get(id);
//				CartItems cartItems = new CartItems();
//				cartItems.setCart(cart);
////				cartItems.setProduct(product);
//				cartItems.setPrice(product.getP_price());
//				cartItemsDao.saveorupdate(cartItems);
//				cart.setGrand_total(cart.getGrand_total() + product.getP_price());
//				cart.setTotal_item(cart.getTotal_item() + 1);
//				cartDao.saveorupdate(cart);
//				session.setAttribute("items", cart.getTotal_item());
//				session.setAttribute("gd", cart.getGrand_total());
//				return new ModelAndView("redirect:/allproducts");
//			}
//		} else {
//			return new ModelAndView("redirect:/");
//		}
//
//	}
//	@RequestMapping("/addtocartR/{id}")
//	public ModelAndView cartr(@PathVariable("id") String id) {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			String currusername = authentication.getName();
//			User u = userDao.getUseremail(currusername);
//			if (user == null) {
//				return new ModelAndView("redirect:/");
//			} else {
//
//				cart = u.getCart();
//				product = productDao.get(id);
//				cartItems.setCart(cart);
//				CartItems cartItems = new CartItems();
////				cartItems.setProduct(product);
//				cartItems.setPrice(product.getP_price());
//				cartItemsDao.saveorupdate(cartItems);
//				cart.setGrand_total(cart.getGrand_total() + product.getP_price());
//				cart.setTotal_item(cart.getTotal_item() + 1);
//				cartDao.saveorupdate(cart);
//				session.setAttribute("items", cart.getTotal_item());
//				session.setAttribute("gd", cart.getGrand_total());
//				return new ModelAndView("redirect:/viewcart");
//			}
//		} else {
//			return new ModelAndView("redirect:/");
//		}
//
//	}
	@RequestMapping("/addtocart/{P_id}")
	public ModelAndView cartc(@PathVariable("P_id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
			if (user == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.get(id);
				CartItems cartItems = new CartItems();
				cartItems.setCart(cart);
				cartItems.setProduct(product);
				cartItems.setPrice(product.getP_price());
				cartItemsDao.saveorupdate(cartItems);
				cart.setGrand_total(cart.getGrand_total() + product.getP_price());
				cart.setTotal_item(cart.getTotal_item() + 1);
				cartDao.saveorupdate(cart);
				session.setAttribute("items", cart.getTotal_item());
				session.setAttribute("gd", cart.getGrand_total());
				return new ModelAndView("redirect:/all_Products");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}


	@RequestMapping(value = "/viewcart")
	public String viewcart(Model model, HttpSession session) {
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
		        Cart c=u.getCart();
				List<CartItems> cartItems = cartItemsDao.getlist(u.getCart().getCart_Id());
				if(cartItems==null ||cartItems.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "viewcart";		
				}
				model.addAttribute("cartItems", cartItems);
				model.addAttribute("gtotal",c.getGrand_total());
				session.setAttribute("items",c.getTotal_item());
			    session.setAttribute("cartId", c.getCart_Id());
				return "viewcart";		
			
		}
		else
		{
			return "redirect:/";
		}
		
	}
	@RequestMapping(value="/Remove/{P_id}")
	public String RemoveFromCart(@PathVariable("P_id") String id)
	{
		cartItems=cartItemsDao.get(id);
		Cart c=cartItems.getCart();
		c.setGrand_total(c.getGrand_total()-cartItems.getPrice());
		c.setTotal_item(c.getTotal_item()-1);
		cartDao.saveorupdate(c);
		CartItems cartitems=cartItemsDao.get(cartItems.getCartItems_id());
		cartItemsDao.delete(cartitems);
		return "redirect:/viewcart";
	}
	
	@RequestMapping(value="/Removeall")
	public String RemoveallFromCart(Model model,HttpSession session)
	{
		Cart c=cartDao.get((String)session.getAttribute("cartId"));
		List<CartItems> cartItems=cartItemsDao.getlist((String)session.getAttribute("cartId"));
		for(CartItems g:cartItems)
		{
			CartItems cartitems=cartItemsDao.get(g.getCartItems_id());
			cartItemsDao.delete(cartitems);
		}
		c.setGrand_total(0.0);
		c.setTotal_item(0);
		cartDao.saveorupdate(c);
		session.setAttribute("items",c.getTotal_item());
		return "redirect:/viewcart";
	}

}
