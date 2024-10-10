package com.ssafy.di;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		Programmer p = context.getBean("progammer", Programmer.class);
		
		p.coding(); // 따로 Computer를 주입하지 않아도 알아서 Bean에서 조립해서 옴
		
	}
}
