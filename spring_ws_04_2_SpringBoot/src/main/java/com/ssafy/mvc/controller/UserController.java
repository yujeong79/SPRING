package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model, HttpSession session) {
		if(user.getId().equals("ssafy") && user.getPassword().equals("1234")) {
			user.setName("김싸피");
			session.setAttribute("loginUser", user);
			model.addAttribute("msg", "로그인 성공!");
			return "index";
		}
		
		model.addAttribute("msg", "로그인 실패!");
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
}
