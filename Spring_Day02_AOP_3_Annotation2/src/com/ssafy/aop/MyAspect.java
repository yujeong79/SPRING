package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 이해가 안가는 것이 있음...
 * 부가 기능들 다 한 번에 모은건 알겠는데 언제 핵심기능을 실행할지를 프록시가 어케 앎? 
 */

// 공통 관심 사항 기능들을 한 번에 저장할 클래스 (단위, 모듈화)
public class MyAspect {
	
	// 메서드 명은 중요하지 않다.
	public void before() {
		System.out.println("컴퓨터를 부팅한다."); // 핵심 기능 이전에 수행해야 할 부가 기능1
	}
	
	public void afterReturning(int num) {
		System.out.println("Git에 Commit한다." + num + "줄을 (시간을)"); // 핵심 기능이 정상적으로 수행되면 수행해야 할 부가 기능2
	}
	
	// 예외를 던질 때 Throwable 객체가 만들어짐
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if(th instanceof OuchException) { // 만약 던져진 Throwable 객체가 OuchException 이라면
			((OuchException)th).handleException();
		}
	}
	
	public void after() {
		System.out.println("쉰다."); // 모든 동작이 완료된 후 수행 할 부가 기능5
	}
	
	/////////////////////////////////////////////////////////////////////////
	// 위는 따로 작성하는 방법, 아래의 around는 한 번에 작성하는 방법
	public void around(ProceedingJoinPoint pjt) { // 핵심 기능이 실행됐을 때의 시점을 가져올 수 있음
		int num = 0;
		
		this.before(); // "컴퓨터를 부팅한다."
		try {
			num = (int) pjt.proceed(); // 핵심 관심 사항을 동작시키고, 해당 기능의 return 값을 num에 받음
			this.afterReturning(num);
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
	}
	
	
}
