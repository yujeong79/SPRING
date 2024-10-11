package com.ssafy.ws;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceClass {

    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("[Before] " + joinPoint.getSignature().toShortString());
    }

	public void afterMethod(JoinPoint joinPoint) {
		System.out.println("[After] " + joinPoint.getSignature().toShortString());
    }

    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around] +++ " + joinPoint.getSignature().toShortString() + " +++");
        // Object[] args = joinPoint.getArgs(); // 메소드의 입력인자를 가져올 수 있다.
        Object obj = joinPoint.proceed();
        System.out.println("[Around] --- " + joinPoint.getSignature().toShortString() + " ---");
        System.out.println("...");
        return obj;
    }

	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		System.out.println("[AfterReturning] " + joinPoint.getSignature().toShortString() + ", result : " + result);
    }

    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) throws Throwable {
        System.out.println("[AfterThrowing] " + joinPoint.getSignature().toShortString() + ", exception : " + ex);
    }
}
