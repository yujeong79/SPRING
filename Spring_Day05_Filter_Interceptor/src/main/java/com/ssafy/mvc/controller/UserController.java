package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		// 원래는 UserService를 통해서 로그인 하는게 맞지만 일단 지금 그걸 다 구현할 수 없으니까
		// id : ssafy, pw : 1234 하면 통과되도록 하자
		
		if(user.getId().equals("ssafy") && user.getPw().equals("1234")) {
			session.setAttribute("loginUser", user.getId());
			return "redirect:hello"; // "hello" 요청을 다시 보내게 돼서 -> HelloController의 /hello 요청으로 들어가게 되고 hello 메서드를 실행하게 된다.
		}
		
		// 아래 코드가 동작한다는 것은 로그인에 실패했다는 뜻!!
		return "redirect:login"; // 다시 로그인으로 보내버리자~
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
