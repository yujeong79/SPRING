package com.ssafy.ws.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

	/* Q. request로 부터 세션을 가져오고, 세션에 id가 없으면 로그인 페이지로 리다이렉트 시키는 코드를 작성하세요.
	 *   - 컨트롤러 실행 전에 세션에 "id"가 있는지 확인을 진행하도록 한다.
	 * 	 - 세션에 "id"가 없다면 로그인 페이지로 리다이렉트 시키고, 추가 실행을 중단합니다. (return false)
	 *   - 세션에 "id"가 있다면 추가 실행을 진행합니다. (return true)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("login");
			return false;
		}
		return true;
	}

}
