package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private final UserService userService;
	
	// @Autowired가 자동으로 된다, 생성자가 하나이기 때문에
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform"; // 참고로 앞에 /를 붙여서 /WEB-INF/views//user/loginform이 되어도 프레임워크가 알아서 지워준다.
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) { // ModelAttribute는 필드명이 아니라 setter의 이름에 맞춰서 값을 넣어주는 것이다!!
		// loginUser : 로그인 성공 -> User 정보 / 로그인 실패 -> null
		User loginUser = userService.login(user.getId(), user.getPassword());
		
		if(loginUser == null) {
			return "redirect:login"; // 로그인 실패하면 다시 로그인 화면으로 redirect
		}
		
		// 로그인 성공하면 
		session.setAttribute("loginUser", loginUser.getName());
		
		return "redirect:list";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
	
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "user/adminPage";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "user/signupform";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user, Model model) {
		if(userService.signup(user)) {
			model.addAttribute("msg", "회원가입 성공");			
		} 
		
		else {
			model.addAttribute("msg", "회원가입 실패");
		}
		
		return "redirect:list";
	}
}
