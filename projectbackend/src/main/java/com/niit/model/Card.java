package com.niit.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Card {
	@Id
	private String Card_id;
	private String Card_no;
	private String Holder_name;
	private String Exp_date;
	
	@ManyToOne
	@JoinColumn(name="User_id")
	private User user;
	
	public Card() {
		this.Card_id ="CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCard_id() {
		return Card_id;
	}
	public void setCard_id(String card_id) {
		Card_id = card_id;
	}
	public String getCard_no() {
		return Card_no;
	}
	public void setCard_no(String card_no) {
		Card_no = card_no;
	}
	public String getHolder_name() {
		return Holder_name;
	}
	public void setHolder_name(String holder_name) {
		Holder_name = holder_name;
	}
	public String getExp_date() {
		return Exp_date;
	}
	public void setExp_date(String exp_date) {
		Exp_date = exp_date;
	}
	

}
