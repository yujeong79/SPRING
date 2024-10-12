package com.ssafy.ws;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.ws.config.AppConfig;
import com.ssafy.ws.dto.Student;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// 스프링의 IoC 컨테이너를 가리키는 인터페이스 (스프링 컨테이너는 빈을 관리하는 컨테이너)
		// * AnnotationConfigApplicationContext : 자바 설정 클래스를 지정하여 컨테이너 초기화
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// AppConfig 클래스에 정의된 빈을 가져온다.
		Student student = context.getBean(Student.class);

		// 학생의 정보를 출력한다.
		System.out.println("<학생의 원래 상태>");
		System.out.println(student);
		System.out.println("------------------------------------------------------------------------");
		// 학생의 입실을 처리하는 메소드 enter
		// 2초 대기
		Thread.sleep(2000);

		System.out.println("입실...!");
		student.enter();
		System.out.println(student);
		System.out.println("------------------------------------------------------------------------");

		// 2초 대기
		Thread.sleep(2000);
		
		// 학생의 퇴실을 처리하는 메소드 leave
		System.out.println("퇴실...!");
		student.leave();
		System.out.println(student);
		System.out.println("------------------------------------------------------------------------");

		// 입실을 두번 시에 예외가 발생한다
		try {
			System.out.println("입실을 두번 시도합니다.");
			Thread.sleep(1000);
			student.enter();
			Thread.sleep(1000);
			student.enter();
		} catch (Exception e) {
			System.err.println("예외 발생! : " + e);
		}
		System.out.println(student);
		System.out.println("------------------------------------------------------------------------");

		// 퇴실을 두번 시에 예외가 발생한다
		try {
			System.out.println("퇴실을 두번 시도합니다.");
			Thread.sleep(1000);
			student.leave();
			Thread.sleep(1000);
			student.leave();
		} catch (Exception e) {
			System.err.println("예외 발생! : " + e);
		}
		System.out.println(student);
		System.out.println("------------------------------------------------------------------------");
	}

}
