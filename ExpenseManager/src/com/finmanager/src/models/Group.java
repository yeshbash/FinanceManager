package com.finmanager.src.models;

public class Group {

	private String _id;
	private String createdBy;
	private String name;
	private String currency;
	
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Group(String _id, String createdBy,String name, String currency) {
		super();
		this._id = _id;
		this.createdBy = createdBy;
		this.name = name;
		this.currency = currency;
	}
	
	
}
