package com.ssafy.di2_객체생성의존성제거;

// 스프링컨테이너 맛보기(의존관계 역전 맛보기)
// Test 클래스 자체가 스프링 컨테이너의 역할
// 스프링컨테이너에서 알아서 만들어서 필요하다면 넣어줌
// => 의존 관계 역전 : Programmer가 desktop에 대해 객체 생성 의존성을 가지고 있었는데
// 이제는 Desktop 생성을 Test에서 해주므로 Desktop에 대한 객체 생성 의존성이 제거됨
// 이렇게 new 생성하는 것을 스프링 컨테이너에 다 모음으로써 객체 생성 의존성을 제거하는거지
// 컨테이너에서 new 생성하는 것은 컨테이너가 알아서 해주는 것이기 때문에 컨테이너가 의존한다고 표현하지는 않음

// 물론 desktop 어떻게 해줘 programmer 어떻게 해줘~ 이런 설정을 해줘야하는데 이건 자바 bean을 등록하면 알아서 해줌
public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop(); // desktop을 미리 만들어놓고
		
		Programmer p = new Programmer(desktop); // programmer를 생성할 때 이미 만들어진 desktop을 넣어줌
		
		p.coding();
	}
}
