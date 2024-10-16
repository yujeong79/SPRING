package com.ssafy.ws.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor{
	/**
	 * 사용자의 요청을 처리하기 전에 session에 loginUser가 있는지 판단한다.
	 * 정보가 있다면 그대로 진행하고, 정보가 없다면 index 페이지로 이동시킨다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			response.sendRedirect("index");
			return false;
		}
		
		return true;
	}
}
