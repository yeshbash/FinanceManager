package com.finmanager.src.models;

import java.util.List;

public class GroupExpenses {

	private String _id;
	private List<Expense> expenses;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public List<Expense> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	public GroupExpenses(String _id, List<Expense> expenses) {
		super();
		this._id = _id;
		this.expenses = expenses;
	}
	
	 
}
