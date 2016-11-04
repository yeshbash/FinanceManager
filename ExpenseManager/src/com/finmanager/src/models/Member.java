package com.finmanager.src.models;
import java.util.List;


public class Member {

	private String _id;
	private String name;
	private String nickName;
	private List<String> groups;
	
	
	public Member(String _id,String name, String nickName, List<String> groups) {
		super();
		this._id = _id;
		this.name = name;
		this.nickName = nickName;
		this.groups = groups;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public List<String> getGroups() {
		return groups;
	}
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	
}
