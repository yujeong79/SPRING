package com.ssafy.di;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		Desktop d = (Desktop) context.getBean("desktop");
		
		System.out.println(d.getInfo());
		
		Programmer p = context.getBean("p", Programmer.class); // annotation 할 때 p를 이름으로 줬음
	}
}
