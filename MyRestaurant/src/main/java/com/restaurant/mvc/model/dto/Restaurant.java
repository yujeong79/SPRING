package com.restaurant.mvc.model.dto;

public class Restaurant {
	
	int id;
	String name;
	String location;
	int categoryCode;
	String categoryName;
	String signatureMenu;
	String phoneNumber;
	String img;
	String orgImg;
	
	public Restaurant() {}

	public Restaurant(int id, String name, String location, int categoryCode, String categoryName, String signatureMenu, String phoneNumber,
			String img, String orgImg) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.signatureMenu = signatureMenu;
		this.phoneNumber = phoneNumber;
		this.img = img;
		this.orgImg = orgImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSignatureMenu() {
		return signatureMenu;
	}

	public void setSignatureMenu(String signatureMenu) {
		this.signatureMenu = signatureMenu;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", categoryCode=" + categoryCode
				+ ", signatureMenu=" + signatureMenu + ", phoneNumber=" + phoneNumber + ", img=" + img + ", orgImg="
				+ orgImg + "]";
	}

}
