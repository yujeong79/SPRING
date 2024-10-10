package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
	// 멤버 필드 생략
	
	public String getInfo() {
		return "랩탑";
	}
}
