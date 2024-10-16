package com.ssafy.ws.dto;

import java.util.Date;

public class Board {
	private int id; // 게시글 아이디
	private String title; // 게시글 제목
	private String content; // 게시글 내용
	private Date created; // 게시글 등록일
	private String author; // 게시글 작성자

	public Board() {
	}

	public Board(int id, String title, String content, Date created, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.created = created;
		this.author = author;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
