package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	// 정석은 Service를 의존성 주입 받아야 한다. => 왜? 몰라....
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		// 1. userService를 통해서(이거 그 실제 기능 구현할 때 service 말하는듯) 
		// 	  실제로 id/pw를 이용하여 DB까지 확인하고 실제 유저가 맞는지 확인해야한다.
		
		// 2. 세션에 정보를 저장해야한다.
		// 왜 세션에 정보를 저장하느냐? 로그인 정보는 페이지 이동할 때마다 달라지는 것이 아니니까!!
		// 일단 지금은 서비스를 구현하지 않아서 냅다 넣었다~ 
		session.setAttribute("loginUser", user.getId());
		
		// return "hello"; => 포워딩 방식, URL 주소가 달라지지 않고 바로 prefix와 suffix가 붙어서 hello.jsp 페이지로 이동한다.
		return "redirect:hello"; // "hello" 요청을 다시 보내게 돼서 -> HelloController의 /hello 요청으로 들어가게 되고 hello 메서드를 실행하게 된다.
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 로그아웃 하는 방법 2가지
		// 1. 세션에서 유저 속성을 지우는 작업
		session.removeAttribute("loginUser");
		
		// 2. 세션 자체를 초기화
		session.invalidate();
		
		return "redirect:/"; // index 페이지로 이동
	}
}
