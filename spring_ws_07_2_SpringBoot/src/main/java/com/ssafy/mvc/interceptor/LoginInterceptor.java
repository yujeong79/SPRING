package com.ssafy.mvc.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private UserDao dao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		User user = dao.selectById(request.getParameter("id"));
		HttpSession session = request.getSession();
		
		if(user != null && user.getPassword().equals(request.getParameter("password"))) {
			session.setAttribute("loginUser", user.getName());
			return true;
		}
		
		response.sendRedirect("/index");
		return false;
	}
	
}
