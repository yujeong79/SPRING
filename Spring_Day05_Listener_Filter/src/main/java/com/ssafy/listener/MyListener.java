package com.ssafy.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    public MyListener() {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션 시작1");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	// 종료된 이후에 실행되기 때문에 콘솔창에서 볼 수 없다.
    	System.out.println("웹 어플리케이션 종료1");
    }
	
}
