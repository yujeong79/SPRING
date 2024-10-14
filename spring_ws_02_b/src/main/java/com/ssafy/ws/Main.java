package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 스프링의 IoC 컨테이너를 가리키는 인터페이스 (스프링 컨테이너는 빈을 관리하는 컨테이너)
        // * AnnotationConfigApplicationContext : 자바 설정 클래스를 지정하여 컨테이너 초기화
    	
    	// 세 가지 DI 방법 중 Java Config 방식을 사용했을 때 컨테이너 객체를 빌드하는 방법이다.	
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
        
        // AppConfig 클래스에 정의된 빈을 가져온다.
        // TargetClass는 @Component 되어 있다.	
        TargetClass targetClass = context.getBean(TargetClass.class);
        
        // TargetClass 객체의 메소드를 호출한다.
        targetClass.method1();
        targetClass.method2();
        targetClass.method3();
        try {
            targetClass.method4();
        } catch (Exception e) {
        	System.err.println("예외 발생! : " + e);
        }
    }
}
