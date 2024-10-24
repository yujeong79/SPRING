package com.ssafy.hw.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {
	
	// 컨트롤러 호출 전에 실행되어야 한다.
	// @Override
	// public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	// 		throws Exception {
	
	// }
	
}

