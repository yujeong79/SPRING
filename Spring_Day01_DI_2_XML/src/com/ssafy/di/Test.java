package com.ssafy.di;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// Test에서 했던 작업들을 Spring Container를 설정파일을 통해서 만들었으니
		// 그 안에 넣고 관리하자
		
		// 스프링 컨테이너 객체 생성하기
		// 설정파일을 가져오는데 우리가 구분하기 좋게 src 폴더와 resources 폴더를 따로 만들었지만 사실 그 둘은 같은 위치에 있는 것이다.
		// 그렇기 때문에 resources/applicationContext.xml 안하고 그냥 applicationContexxt.xml만 쓰면 된다.
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너를 빌드할 때 빈 등록한 클래스들의 객체가 생성되고 가지고 있다.
		// getBean 하면 가지고 있는 객체를 준다.
		
		// 이제 new 하지 않아~ 왜냐면 bean 에서 관리 해주니까~
		Programmer p = (Programmer) context.getBean("programmer"); // => getBean을 통해서 객체를 가져옴
		Desktop desktop1 = context.getBean("desktop", Desktop.class); // 아니면 형변환을 하지 않고 이건 Desktop이야~ 이렇게 알려주는 방법이 있음
	
		p.setComputer(desktop1);
		p.coding();
		
		Desktop desktop2 = context.getBean("desktop", Desktop.class);
		
		// desktop1과 desktop2는 같은 객체, 기본적으로 객체를 Singleton으로 관리
		// Scope를 사용해서 변경해줄 수 있음
	}
}
