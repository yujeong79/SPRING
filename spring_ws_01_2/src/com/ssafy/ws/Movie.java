package com.ssafy.ws;

// 느슨한 결합을 위한 인터페이스
// Action 클래스이던 Comic 클래스이던 타입 의존성을 제거하기 위해서
public interface Movie {
	
	// 모든 구현체에서 Override 해야하는 추상 메소드
	String getInfo();
	
}
