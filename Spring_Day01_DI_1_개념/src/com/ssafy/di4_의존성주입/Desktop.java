package com.ssafy.di4_의존성주입;

public class Desktop implements Computer{
	// 멤버 필드 작성
	private String CPU;
	private String RAM;
	// ... 작성을 할 수 있다. 오늘은 Desktop의 멤버 필드를 정확하게 작성하는 것이 안중요하니 대충 패스
	
	public String getInfo() { // 정보를 반환하는 메소드
		return "데스트톱";
	}
	
}
