package com.ssafy.di1_의존성개념;

// Programmer는 컴퓨터가 필요하다.
public class Programmer {
	private Desktop desktop;
	
	public Programmer() {
		// 프로그래머를 한 명 생성하면 자동으로 프로그래머에게 Desktop이 생성됨
		this.desktop = new Desktop();
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() + "으로 개발을 합니다.");
	}
}
