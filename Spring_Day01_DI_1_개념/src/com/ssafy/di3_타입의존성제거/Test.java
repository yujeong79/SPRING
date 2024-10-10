package com.ssafy.di3_타입의존성제거;

public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop(); // desktop을 미리 만들어놓고
		Laptop laptop = new Laptop();
		
		// laptop을 넣어주던 desktop을 넣어주던 알아서 타입 관계 없이 해줬으면 좋겠어
		// 그럴 때 필요한 것이 인터페이스!! 다형성!! => 느슨한 결합
		Programmer p1 = new Programmer(desktop);
		Programmer p2 = new Programmer(laptop);
		
		p1.coding();
		p2.coding();
	}
}
