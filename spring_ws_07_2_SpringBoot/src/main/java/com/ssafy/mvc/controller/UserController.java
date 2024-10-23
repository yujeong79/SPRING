package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@PostMapping("/login")
	public String login() {
		return "index";
	}
	
	@GetMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "user/signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user, @RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		
		if(file != null && file.getSize() > 0) {
			user.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			user.setOrgImg(file.getOriginalFilename());
			
			Resource resource = resourceLoader.getResource("classpath:/static/img/");
			file.transferTo(new File(resource.getFile(), user.getImg()));
		}
		
		if(service.regist(user)) {
			model.addAttribute("msg", "회원가입 성공!");
		}
		
		else
			model.addAttribute("msg", "회원가입 실패!");
		
		return "user/regist_result";
	}
}
