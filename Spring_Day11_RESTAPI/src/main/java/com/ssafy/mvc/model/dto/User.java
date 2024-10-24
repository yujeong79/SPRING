package com.ssafy.mvc.model.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private int curriculumCode;
	private String curriculumName;
	
	public User() {
		// TODO Auto-generated constructor stub
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

	public int getCurriculumCode() {
		return curriculumCode;
	}

	public void setCurriculumCode(int curriculumCode) {
		this.curriculumCode = curriculumCode;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", curriculumCode=" + curriculumCode
				+ ", curriculumName=" + curriculumName + "]";
	}

}
