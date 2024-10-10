package com.ssafy.di4_의존성주입;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop(); // desktop을 미리 만들어놓고
		Laptop laptop = new Laptop();
		
		Programmer p1 = new Programmer();
		
		// 객체를 생성할 때는 Computer를 주지 않고 나중에 주고 싶을 때
		// 설정자를 사용해서 나중에 주입
		p1.setComputer(laptop);
		
		p1.coding();
		
		// 공장 개시!!
		// 기존에는 실행 환경에서 어떤 조작을 통해서 부품을 갈아끼움!
		// 그니까 전에는 desktop laptop을 미리 생성해서 p1에 뭘 주고 p2에 뭘 주고 이렇게 했는데
		// 아래의 방법은 실시간으로 필요한 컴퓨터를 생성해서 p2에 Computer를 주입
		Scanner sc = new Scanner(System.in);
		
		Programmer p2 = new Programmer();
		
		while(true) {
			p2.setComputer(ComputerFactory.getComputer(sc.next()));
			p2.coding();
		}
	}
}
