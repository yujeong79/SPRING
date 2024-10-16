package com.ssafy.ws.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("loginInterceptor")
public class LoginInterceptor implements HandlerInterceptor {

	/*
	 * 컨트롤러의 메서드가 호출되기 전에 실행되는 메서드 세션에 id가 없다면 로그인 페이지로 리다이렉트
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}

}
