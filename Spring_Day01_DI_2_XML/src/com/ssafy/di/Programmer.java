package com.ssafy.di;

// 객체생성의존성
public class Programmer {
	private Computer computer;
	
	public Programmer() {
		// TODO Auto-generated constructor stub
	}
	
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	// 설정자를 이용해서 주입
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	// 메서드를 사용해서도 주입할 수 있어!! 상황에 따라 그때그때 판단

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다.");
	}
}
