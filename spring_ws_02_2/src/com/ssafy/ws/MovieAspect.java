package com.ssafy.ws;

public class MovieAspect {
		
	public void before() { // Target 메서드 실행 이전
		System.out.println("영화관을 갑니다.");
	}
	
	public void afterReturning() { // Target 메서드 정상 실행 이후
		System.out.println("영화가 끝나고 나옵니다.");
	}
	
	public void afterThrowing() { // Target 메서드 실행 에러 이후
		System.out.println("전화를 받습니다.");
	}
	
	public void after() { // 완전 종료 이후
		System.out.println("집에 갑니다.");
	}
}
