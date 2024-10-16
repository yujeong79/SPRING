package com.ssafy.mvc.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

// MyFilter를 사용하기 위해 Bean으로 등록
// 단, 이렇게 설정하면 단점이 경로를 지정할 수 없어서 모든 요청에 대해서 이 필터가 동작하게 된다.
//@Component
//@Order(2) // Order 어노테이션을 통해서 Filter 순서 지정 가능
public class MyFilter2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MyFilter2 : 서블릿으로 가기 전");
		chain.doFilter(request, response); // doFilter를 해야지만 요청이 servlet으로 넘어간다.
		System.out.println("MyFilter2 : 서블릿으로 간 후");
	}

}
