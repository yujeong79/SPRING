package com.ssafy.ws;

public class TargetClass {
    public void method1() {
        System.out.println("메소드1가 실행되었습니다.");
    }

    public void method2() {
        System.out.println("메소드2가 실행되었습니다.");
    }

    public String method3() {
        System.out.println("메소드3가 실행되었습니다.");
        return "메소드 3의 반환값";
    }
    
	public void method4() throws Exception {
		System.out.println("메소드4가 실행되었습니다.");
		throw new RuntimeException("메소드4에서 예외를 발생시켰습니다!");
	}
}
