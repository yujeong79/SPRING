package com.ssafy.di3_타입의존성제거;

// 객체생성의존성
public class Programmer {
	private Computer computer;
	
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다.");
	}
}
