package com.ssafy.mvc.model.dto;

public class Movie {
	int id;
	String title;
	String director;
	String genre;
	String content;
	int runningTime;
	String img = "none";
	String orgImg = "none";
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(int id, String title, String director, String genre, String content, int runningTime, String img, String orgImg) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.content = content;
		this.runningTime = runningTime;
		this.img = img;
		this.orgImg = orgImg;
	}

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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
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
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", content="
				+ content + ", runningTime=" + runningTime + "]";
	}
	
}
