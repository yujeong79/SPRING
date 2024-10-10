package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="p")
public class Programmer {
	private Computer computer;
	
	public Programmer() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자를 이용해서 주입
	@Autowired
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	// 설정자를 이용해서 주입
	@Autowired
	public void setComputer(@Qualifier("desktop") Computer computer) { // 여기에 computer로 Desktop과 Laptop 두 가지가 올 수 있기 때문에 Qualifier로 결정을 해줌
		this.computer = computer;
	}
	
	// 메서드를 사용해서도 주입할 수 있어!! 상황에 따라 그때그때 판단

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다.");
	}
}
