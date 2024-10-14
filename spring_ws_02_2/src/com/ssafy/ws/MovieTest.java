package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		
		ApplicationContext appCtx = new GenericXmlApplicationContext("applicationContext.xml");
		Audience audience = appCtx.getBean("audience", Audience.class);
		
		try {
			audience.doSomething();
		} catch (CallException e) {
		}

	}
}
