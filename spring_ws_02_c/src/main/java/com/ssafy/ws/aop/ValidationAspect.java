package com.ssafy.ws.aop;

import java.util.Date;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.ssafy.ws.dto.Student;

@Aspect
@Component
public class ValidationAspect {
	/*
		Joinpoint:
		- 특정 작업이 실행되는 특정 시점을 나타냅니다. (메소드 호출, 필드 접근 등)
		- Advice가 적용될 수 있는 위치를 나타냅니다. (Advice가 적용될 수 있는 위치는 메소드 호출 전, 후, 예외 발생 시 등등)

		JoinPoint와 ProceedingJoinPoint는 AspectJ 프레임워크에서 제공하는 인터페이스로, 
		AOP(Aspect-Oriented Programming)에서 Advice가 적용되는 대상인 Join Point를 나타냅니다.

		"JoinPoint" 인터페이스는 Advice가 적용될 때 해당 지점의 상세 정보를 제공하며 아래와 같은 메소드를 제공합니다.
		- Object getTarget(): 대상(target) 객체를 반환합니다. (프록시가 없는 원래의 객체)
		- Object[] getArgs(): 현재 Join Point의 메소드 인자를 반환합니다.
		- Signature getSignature(): 현재 Join Point의 시그니처(메소드 이름, 파라미터 타입 등)를 반환합니다.
		- Object getThis(): 대신 호출되는 프록시 대상 객체를 반환합니다.

		"ProceedingJoinPoint" 인터페이스는 JoinPoint를 상속받아서, 메소드 실행을 직접 제어할 수 있는 메소드를 추가로 제공합니다.
		- Object proceed() throws Throwable: 원래의 메소드를 호출합니다. (이 메소드는 예외를 던질 수 있으므로 호출하는 곳에서는 적절한 예외 처리를 해야 합니다.)
		- Object proceed(Object[] args) throws Throwable: 인자를 변경하여 원래의 메소드를 호출합니다. (이 메소드는 예외를 던질 수 있으므로 호출하는 곳에서는 적절한 예외 처리를 해야 합니다.)
	*/
	 // 입실 상태에서 다시 입실할 수 없도록 예외를 발생시키는 aroundEnter 메소드
	 // Q3. 원 target 객체의 enter 메소드를 호출하시오.
	@Around("execution(* com.ssafy.ws.dto.Student.enter(..))")
	public void aroundEnter(JoinPoint joinPoint) throws Throwable {
		Student student = (Student) joinPoint.getTarget();
		if (student.getState().equals("입실")) {
			throw new IllegalStateException("이미 입실을 진행한 학생입니다.");
		} else {
			// getTarget() 메소드로 가져온 대상 객체는 프록시 객체가 아닌 원 객체이므로 
			student.enter();
		}
	}
	
	// 퇴실 상태에서는 다시 퇴실할 수 없도록 예외를 발생시키는 aroundLeave 메소드
	// Q4. joinPoint를 통해 원래의 메소드를 호출하시오.
	@Around("execution(* com.ssafy.ws.dto.Student.leave(..))")
	public void aroundLeave(JoinPoint joinPoint) throws Throwable {
		Student student = (Student) joinPoint.getTarget();
		if (student.getState().equals("퇴실")) {
			throw new IllegalStateException("이미 퇴실을 진행한 학생입니다.");
		} else {
			student.leave();;
		}
	}

}
