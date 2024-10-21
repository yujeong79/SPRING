package com.ssafy.ws.model.dto;

public class DateDto {
    private int year;
    private int month;
    private int day;
    
    // constructor
	public DateDto() {

	}
    
	// getter, setter
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
    
	public String toString() {
		return year + "년 " + month + "월 " + day + "일";
	}
}
