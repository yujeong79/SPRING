package com.ssafy.di;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Programmer p = context.getBean("p", Programmer.class); // annotation 할 때 p를 이름으로 줬음
		
		p.coding();
	}
}
