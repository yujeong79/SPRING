package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Interceptor는 HandlerInterceptor를 구현한 클래스
@Component
public class AInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// boolean 반환 타입
		// true : 계속 진행, false : 중지
		System.out.println("A : pre");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 정상적으로 요청 처리가 됐다면 실행
		// 예외 발생 시 실행되지 않음
		System.out.println("A : post");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// View가 전달된 후 실행 (예외 발생 여부와 상관없이 무조건 실행)
		// 예외 미발생시 Exception ex
		// 예외 발생 시 Exception ex는 해당 예외 객체
		System.out.println("A : after");
	}
	
}
