package com.ssafy.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener2 implements ServletContextListener {

    public MyListener2() {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션 시작될 때 호출 2");
    	
    	// Servlet Context의 정보를 가져올 수 있다.
    	ServletContext context = sce.getServletContext();
    	
    	// web.xml에 context-param으로 지정한 초기 속성값을 param-name으로 가져올 수 있다.
    	System.out.println(context.getInitParameter("Welcome"));
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	// 종료된 이후에 실행되기 때문에 콘솔창에서 볼 수 없다.
    	System.out.println("웹 어플리케이션 종료2");
    }
	
}
