package com.ssafy.mvc.model.dto;

public class User {
	String id;
	String password;
	String name;
	String img;
	String orgImg;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String img, String orgImg) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.orgImg = orgImg;
	}

	public User(String id, String password, String name, String img, String orgImg) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.img = img;
		this.orgImg = orgImg;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", img=" + img + ", orgImg=" + orgImg
				+ "]";
	}
	
}
