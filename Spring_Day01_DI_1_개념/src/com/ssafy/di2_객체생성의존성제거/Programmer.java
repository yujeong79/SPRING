package com.ssafy.di2_객체생성의존성제거;

// 객체생성의존성
public class Programmer {
	private Desktop desktop;
	
// 프로그래머를 생성할 때마다 Desktop을 new 해서 생성해주어야 함
//	public Programmer() {
//		this.desktop = new Desktop();
//	}
	
	// 객체 생성 의존성을 제거하고 싶으면 인자로 원래 가지고 있던 desktop 객체를 넘겨줌
	public Programmer(Desktop desktop) {
		this.desktop = desktop;
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() + "으로 개발을 합니다.");
	}
}
