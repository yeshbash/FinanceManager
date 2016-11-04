package com.finmanager.src.models;

import java.util.Date;

public class Expense {

	private Integer id;
	private String name;
	private String category;
	private Double amount;
	private Date date;
	private String comments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Expense(Integer id,String name, String category, Double amount, Date date,
			String comments) {
		super();
		this.id= id;
		this.name = name;
		this.category = category;
		this.amount = amount;
		this.date = date;
		this.comments = comments;
	}
	
	
}
