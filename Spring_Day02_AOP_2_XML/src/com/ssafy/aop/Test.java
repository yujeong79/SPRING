package com.ssafy.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		// getBean("id명", 들어올 객체의 타입)
		Person p = context.getBean("programmer", Person.class);
		
		try {
			p.coding(); // person.coding()을 호출하면 proxy.coding()이 호출됨			
		} catch (Exception e) {
		}
		
	}
}
