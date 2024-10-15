package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.dto.User;

@Controller
public class UserController {
	
	@GetMapping("/regist")
	public String registForm() {
		return "registForm";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "regist_result";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy1", "1234", "김싸피", "ssafy1@ssafy.com", 26));
	 	list.add(new User("ssafy2", "1234", "박싸피", "ssafy2@ssafy.com", 26));
	 	list.add(new User("ssafy3", "1234", "이싸피", "ssafy3@ssafy.com", 26));
	 	list.add(new User("ssafy4", "1234", "강싸피", "ssafy4@ssafy.com", 26));
		
	 	model.addAttribute("list", list);
	 	
	 	return "list";
	}
}
