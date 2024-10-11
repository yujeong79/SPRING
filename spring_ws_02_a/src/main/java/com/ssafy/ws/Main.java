package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // IoC 컨테이너를 생성 (ApplicationContext.xml 파일을 읽어서 IoC 컨테이너를 생성한다.)
        ApplicationContext context = new GenericXmlApplicationContext("ApplicationContext.xml");
        // IoC 컨테이너로부터 TargetClass 객체를 가져온다.
        TargetClass targetClass = context.getBean(TargetClass.class);

        // TargetClass 객체의 메소드를 호출한다.
        targetClass.method1();
        targetClass.method2();
        targetClass.method3();
        try {
			targetClass.method4();
		} catch (Exception e) {
			System.err.println("예외 발생! : " + e);
//			e.printStackTrace();
		}
    }
}
