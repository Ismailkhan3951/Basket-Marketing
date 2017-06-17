package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.BillingAddressDao;
import com.niit.dao.CardDao;
import com.niit.dao.CartDao;
import com.niit.dao.CartItemsDao;
import com.niit.dao.OrderDao;
import com.niit.dao.OrderItemsDao;
import com.niit.dao.PaymentDao;
import com.niit.dao.ProductDao;
import com.niit.dao.ShipingAddressDao;
import com.niit.dao.UserDao;
import com.niit.model.BillingAddress;
import com.niit.model.Card;
import com.niit.model.Cart;
import com.niit.model.CartItems;
import com.niit.model.Order;
import com.niit.model.OrderItems;
import com.niit.model.Payment;
import com.niit.model.Product;
import com.niit.model.ShipingAddress;
import com.niit.model.User;

@Controller
public class OrderController {
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItems1;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	BillingAddress billingaddress;
	@Autowired
	BillingAddressDao billingaddressDao;
	@Autowired
	ShipingAddress shipingAddress;
	@Autowired
	ShipingAddressDao shipingAddressDao;
//	@Autowired
//	Payment payment;
//	@Autowired
//	PaymentDao paymentDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItems> cartItems;
	
//	@Autowired
//    private JavaMailSender mailSender;
	
	String o;
	

	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			product=null;
			cartItems1 = (CartItems) cartItemsDao.getlist(cart.getCart_Id());
			if(cartItems1==null)
			{
				return "redirect:/viewcart";
			}
			else
			{
				billingaddress = billingaddressDao.get(user.getEmail_id());
				Object shippingAddressDao;
				List<ShipingAddress> shipingAddresies = shipingAddressDao.getaddbyuser(user.getEmail_id());
				
				model.addAttribute("billingaddress", billingaddress);
				model.addAttribute("user", user);
				model.addAttribute("shipingAddresies", shipingAddresies);
				model.addAttribute("shipingAddress", new ShipingAddress());
				session.setAttribute("p", product);
			}
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/Buy/{P_id}/{CartItems_id}")
	public String order(@PathVariable("P_id") String id, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			cartItems1=null;
//			product = productDao.getproductC(id);
			billingaddress = billingaddressDao.get(user.getEmail_id());
			List<ShipingAddress> shipingAddress = shipingAddressDao.getaddbyuser(user.getEmail_id());
			
			model.addAttribute("billingaddress", billingaddress);
			model.addAttribute("user", user);
			model.addAttribute("shipingAddress", shipingAddress);
			model.addAttribute("shipingAddress", new ShipingAddress());
			session.setAttribute("p", product);
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shipingAddress") ShipingAddress sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shipingAddress = sh;
		model.addAttribute("billingaddress", billingaddress);
		model.addAttribute("shipingAddress", shipingAddress);
		model.addAttribute("prot", product);
		model.addAttribute("cartItems",cartItems1);
		model.addAttribute("cart",cart);
		return "thankyou";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
		List<ShipingAddress> shipingAddress = shipingAddressDao.getaddbyuser(user.getEmail_id());
		model.addAttribute("shipingAddress", shipingAddress);
		model.addAttribute("billingaddress", billingaddress);
		model.addAttribute("shipingAddress", shipingAddress);
		model.addAttribute("product", product);
		
		return "addressorder";
	}

//	@RequestMapping("/payment")
//	public String payment(Model model) {
//		List<Card> cards = cardDao.getcardbyuser(user.getEmail_id());
//		model.addAttribute("cards", cards);
//		model.addAttribute("card", new Card());
//		return "Payment";
//	}

//	@RequestMapping("/payment")
//	public String payment(@RequestParam("payb") String str, @RequestParam("otp")String otp, @ModelAttribute("card")Card c, Model model) {
//				
// 		System.out.println(1324);
//		int a;
//		System.out.println(str);
//				
//		if (str.equalsIgnoreCase("Start Subscription")) {
//			a = 2;
//		} else {
//			a = Integer.parseInt(str);
//		}
//		System.out.println(a);
//		
//		switch (a) {
//		case 1:
//				if(otp.equals(o))
//				{
//					payment.setPayment_id("COD");
//					payment.setPayment_Status("no");
//				}
//				else
//				{
//					return "redirect:/pay";
//				}
//			 
//			break;
//		case 2:
//			payment.setPayment_id("card");
//			payment.setPayment_Status("yes");
//			paymentDao.saveorupdate(payment);
//			cardDao.saveorupdate(c);
//
//			break;
//		case 3:
//			payment.setPayment_id("Internet Banking");
//			payment.setPayment_Status("yes");
//
//		}
//
//		return "redirect:/orderconfirmation";
//	}

	@RequestMapping("/orderconfirmation")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBillingAddress(billingaddress);
		order.setShipingAddress(shipingAddress);
//		order.setPayment(payment);
		order.setUser(user);
		System.out.println(524);
		if (cartItems == null || cartItems.isEmpty()) 
		{
			order.setGrand_total(product.getP_price());//_total(product.getP_id());
			orderDao.saveorupdate(order);
			orderItems.setOrder(order);
			orderItems.setP_id(product.getP_id());
			orderItemsDao.saveorupdate(orderItems);
			cart.setGrand_total(cart.getGrand_total() - cartItems1.getPrice());//getPrice());
			cart.setTotal_item(cart.getTotal_item() - 1);
			session.setAttribute("items", cart.getTotal_item());
			cartDao.saveorupdate(cart);
//			cartItemsDao.delete(cartItemsDao.getlistall(cart.getCart_Id(),product.getP_id()).getCartItems_id());
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setGrand_total(cart.getGrand_total());
			orderDao.saveorupdate(order);
			for(CartItems c:cartItems)
			{
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setP_id(c.getProduct().getP_id());
				System.out.println(3443);
				orderItemsDao.saveorupdate(orderItems);
				CartItems cartItemms = cartItemsDao.get(c.getCartItems_id());
				cartItemsDao.delete(cartItemms);
			}
			cart.setGrand_total(0.0);
			cart.setTotal_item(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotal_item());
			cartDao.saveorupdate(cart);
		}
		cartItems=null;
		cartItems=null;
		product=null;
		order=new Order();
		orderItems=new OrderItems();
		System.out.println(565);
		return "thankyou";
	}


@RequestMapping(value="/SendMail")
public void SendMail() {
	System.out.println(21312);
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
	String currusername = authentication.getName();
	user = userDao.getUseremail(currusername);      
//	Otpganarater ot=new Otpganarater();
//	String o=ot.Otpga();
//	o=ot.Otpga();
//	String recipientAddress = user.getU_email();
//	String subject="OTP";
//String subject = request.getParameter("subject");
String message = "your one time password is "+o+" ";

// prints debug info
//System.out.println("To:" + recipientAddress);
//System.out.println("Subject: " + subject);
System.out.println("Message: " + message);

    
//System.out.println("OTP:"+ otp);
// creates a simple e-mail object
//SimpleMailMessage email = new SimpleMailMessage();
//email.setTo(recipientAddress);
//email.setSubject(subject);
//email.setText(message);
//email.setSubject(otp);
// sends the e-mail
//mailSender.send(email);

 
// forwards to the view named "Result"
//return "Result";
}
}
}
