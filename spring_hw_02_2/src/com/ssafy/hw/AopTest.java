package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new GenericXmlApplicationContext("applicationContext.xml");
		User generalUser = appCtx.getBean("generalUser", User.class);
		User adminUser = appCtx.getBean("adminUser", User.class);
		
		System.out.println("******1.GeneralUser");
		try {
			generalUser.useApp();
		} catch (ApplicationException e) {
		}
		
		System.out.println("******2.AdminUser");
		try {
			adminUser.useApp();
		} catch (ApplicationException e) {
		}
	}

}
