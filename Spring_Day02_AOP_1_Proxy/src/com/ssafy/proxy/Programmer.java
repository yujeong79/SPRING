package com.ssafy.proxy;

import java.util.Random;

// 프로그래머의 일상
// 프로그래머의 일상은 Ssafy 교육생의 일상과 핵심 기능만 다를 뿐, 나머지 부가 기능이 똑같다.
public class Programmer {
	// 멤버 필드는 생략
	
	public void coding() {
		System.out.println("컴퓨터를 부팅한다."); // 핵심 기능 이전에 수행해야 할 부가 기능1
		
		try {
			System.out.println("열심히 코드를 작성한다."); // 핵심 관심 사항 기능
			
			if(new Random().nextBoolean()) // 이건 그냥 수업용으로 랜덤하게 예외를 발생시키기 위한 코드+
				throw new OuchException();
			
			System.out.println("Git에 Commit한다."); // 핵심 기능이 정상적으로 수행되면 수행해야 할 부가 기능2			
		} catch (OuchException e) { // 핵심 기능을 정상적으로 수행하지 못한 경우에 동작할
			e.handleException(); // 부가 기능3
			System.out.println("조퇴를 한다."); // 부가 기능4
		} finally {
			System.out.println("쉰다."); // 모든 동작이 완료된 후 수행 할 부가 기능5
		}
		
	}
}
