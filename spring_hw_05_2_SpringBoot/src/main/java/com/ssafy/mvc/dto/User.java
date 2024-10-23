package com.ssafy.mvc.dto;

public class User {
	String id;
	String password;
	String name;
	String email;
	int age;
	String img = "none";
	String orgImg = "none";
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String password, String name, String email, int age, String img, String orgImg) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", img=" + img + ", orgImg=" + orgImg + "]";
	}

}
