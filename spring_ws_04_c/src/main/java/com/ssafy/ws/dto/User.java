package com.ssafy.ws.dto;

public class User {

	private String id; // 사용자 아이디
	private String pw; // 사용자 비밀번호
	
	public User() {
	}
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
}
