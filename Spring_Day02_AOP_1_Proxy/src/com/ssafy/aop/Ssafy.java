package com.ssafy.aop;

import java.util.Random;

// SSAFY 교육생의 일상
// 교육생의 일상은 프로그래머의 일상과 핵심 기능만 다를 뿐, 나머지 부가 기능이 똑같다.
public class Ssafy implements Person{
	// 멤버 필드는 생략
	
	public void coding() {
		System.out.println("열심히 공부를 작성한다."); // 핵심 관심 사항 기능
	}
	
}