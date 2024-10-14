package com.ssafy.ws.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // Q1. Student 클래스의 enter 메소드 실행 전에 beforeEnterClass를 실행하게 합니다.
    @Before("execution(* com.ssafy.ws.dto.Student.enter(..))")
    public void beforeEnterClass() {
        System.out.println("입실 버튼을 누릅니다.");
    }

    // Q2. Student 클래스의 leave 메소드 실행이 완료된 후에 afterLeaveClass를 실행하게 합니다.
    @After("execution(* com.ssafy.ws.dto.Student.leave(..))")
    public void afterLeaveClass() {
        System.out.println("퇴실이 완료되었습니다.");
    }
}