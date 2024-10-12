package com.ssafy.ws;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Aspect : 이 클래스가 Aspect 역할을 한다는 것을 의미한다.
@Component
@Aspect
public class AspectClass {
	// Q1. com.ssafy.ws.TargetClass의 모든 메소드의 실행 전, 후에 aroundMethod 메소드를 실행한다.
	@Around("execution(* *())")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[Around] +++ " + joinPoint.getSignature().toShortString() + " +++");
		// Object[] args = joinPoint.getArgs(); // 메소드의 입력인자를 가져올 수 있다.
		Object obj = joinPoint.proceed();
		System.out.println("[Around] --- " + joinPoint.getSignature().toShortString() + " ---");
		System.out.println("...");
		return obj;
	}

	// Q2. com.ssafy.ws 패키지 내의 모든 클래스의 모든 메소드 실행 전에 beforeMethod 메소드를 실행하도록 point
	// cut과 advice를 분리하여 작성한다.
	// Q2-1. pointcut2() 메소드를 정의하여 point cut을 작성한다.
	@Pointcut("execution(* *())")
	public void pointcut2() {
	}

	// Q2-2. pointcut2() 메소드를 이용하여 beforeMethod 메소드를 작성한다.
	@Before("pointcut2()")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("[Before] " + joinPoint.getSignature().toShortString());
	}

	// Q3. com.ssafy.ws.TargetClass의 method2 메소드의 실행 후에 afterMethod 메소드를 실행한다.
	@After("execution(* com.ssafy.ws.TargetClass.method2())")
	public void afterMethod(JoinPoint joinPoint) {
		System.out.println("[After] " + joinPoint.getSignature().toShortString());
	}

	// Q4. 반환 타입이 String인 모든 메소드가 정상적으로 실행된 후에 afterReturningMethod 메소드를 실행한다.
	@AfterReturning(value = "execution(String *())", returning = "result")
	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		System.out.println("[AfterReturning] " + joinPoint.getSignature().toShortString() + ", result : " + result);
	}

	// Q5. RuntimeException 예외를 던지는 모든 메소드가 예외가 발생한 후에 afterThrowingMethod 메소드를
	// 실행한다.
	@AfterThrowing(value = "execution(* *() throws java.lang.RuntimeException)", throwing = "ex")
	public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) throws Throwable {
		System.out.println("[AfterThrowing] " + joinPoint.getSignature().toShortString() + ", exception : " + ex);
	}
}
