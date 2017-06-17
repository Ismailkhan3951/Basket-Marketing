package com.niit.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Orders")
@Component
public class Order {
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateFormat dtf = new SimpleDateFormat("HH:mm:ss");
	
	private static final long SerialVersionUID=1l;
	@Id
	private String Order_id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name ="Bill_id")
	BillingAddress billingAddress;

	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name ="ship_id")
	ShipingAddress shipingAddress;

	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name ="Payment_id")
	Payment Payment;

	@OneToOne
	@JoinColumn(name ="User_id")
	User user;

	
	private double Grand_total;
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	List<OrderItems> orderItems ;
	
	private String Order_date;
	 private String ordertime;
		public Order() {
			Date date = new Date();
			Order_date=sdf.format(date);
			Calendar cal = Calendar.getInstance();
			Date date1 = new Date();
			ordertime=dtf.format(date1);
			this.Order_id = UUID.randomUUID().toString().substring(30).toUpperCase();
		}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public ShipingAddress getShipingAddress() {
		return shipingAddress;
	}
	public void setShipingAddress(ShipingAddress shipingAddress) {
		this.shipingAddress = shipingAddress;
	}
	public Payment getPayment() {
		return Payment;
	}
	public void setPayment(Payment payment) {
		Payment = payment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	private String Order_time;
	public String getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	public double getGrand_total() {
		return Grand_total;
	}
	public void setGrand_total(double grand_total) {
		Grand_total = grand_total;
	}
	public String getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(String order_date) {
		Order_date = order_date;
	}
	public String getOrder_time() {
		return Order_time;
	}
	public void setOrder_time(String order_time) {
		Order_time = order_time;
	}
	
}
