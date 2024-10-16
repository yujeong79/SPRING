package com.ssafy.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	
	@GetMapping("list")
	public String registForm() {
		return "list";
	}

	@GetMapping("login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("login")
	public String login(HttpSession session, String id, String pw) {
		// 아이디와 비밀번호가 ssafy, 1234라면 세션에 id를 저장하고 메인페이지로 이동
		if (id.equals("ssafy") && pw.equals("1234")) {
			session.setAttribute("id", id);
			return "redirect:/";
		}

		// 일치하지 않는다면 로그인 페이지로 이동
		return "redirect:/login";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		// 세션에 저장된 id를 제거하고 메인페이지로 이동
		session.removeAttribute("id");
		return "redirect:/";
	}
}
