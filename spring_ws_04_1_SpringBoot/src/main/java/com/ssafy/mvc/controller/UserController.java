package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;
import com.ssafy.mvc.model.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private static UserService userService = UserServiceImpl.getInstance();

	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		if(userService.login(user) != null) { // 로그인 성공하면 session에 해당 유저의 정보를 저장
			session.setAttribute("loginUser", user);
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/registUser")
	public String registUserForm() {
		return "registUser";
	}
	
	@GetMapping("/registUser")
	public String registUser(@ModelAttribute User user, Model model) {
		if(userService.insertUser(user)) {
			model.addAttribute("user", user);
			return "registUserResult";
		}
		
		return "registUser";
	}
	
	@GetMapping("/myPage")
	public String myPage() {
		return "myPage";
	}
}
