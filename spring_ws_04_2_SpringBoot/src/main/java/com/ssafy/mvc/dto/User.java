package com.ssafy.mvc.dto;

public class User {
	String id;
	String password;
	String name;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public User(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
}
