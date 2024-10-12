package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarTest {
	public static void main(String[] args) {
		//테스트 코드작성
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		Driver driver = context.getBean("driver", Driver.class);
		
		try {
			driver.doSomething();
		} catch (GasException e) {
		}
		
	}
}
