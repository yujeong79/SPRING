package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session, Model model) {
		if(user.getId().equals("ssafy") && user.getPassword().equals("1234") ) {
			user.setName("김싸피");
			user.setEmail("ssafy@ssafy.com");
			user.setAge(25);
			
			model.addAttribute("msg", "로그인 성공!");
			session.setAttribute("loginUser", user);
		} else {
			model.addAttribute("msg", "로그인 실패!");
		}
		
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "regist_form";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "regist_result";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<User> users = new ArrayList<>();
		
		User user1 = new User("ssafyLee", "1234", "이싸피", "ssafyLee@ssafy.com", 28);
		User user2 = new User("ssafyPark", "1234", "박싸피", "ssafyPark@ssafy.com", 26);
		User user3 = new User("ssafyChoi", "1234", "최싸피", "ssafyChoi@ssafy.com", 24);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		model.addAttribute("users", users);
		
		return "list";
	}
	
}
