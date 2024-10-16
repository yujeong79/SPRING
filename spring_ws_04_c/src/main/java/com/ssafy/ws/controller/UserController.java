package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private List<User> users = new ArrayList<>();
	private int nxtId = 1;
	
	public UserController() {
		users.add(new User("ssafy", "1234"));
		users.add(new User("multi", "qwer"));
		users.add(new User("samsung", "1q2w3e"));
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/*
	 * Q. 로그인 기능을 구현하기 위해 UserController에 loginForm 메소드를 완성하세요.
	 * - /WEB-INF/views/login.jsp로 이동 (로그인 폼으로 이동)
	 */
	@GetMapping("login")
	public String loginForm() {
		return "login";
	}

	/*
	 * Q. 로그인 기능을 구현하기 위해 UserController에 login 메소드를 완성하세요.
	 * - id, pw를 매개변수로 받아서 users에 있는지 확인
	 * - 있다면 세션에 id를 저장하고 메인페이지로 이동
	 * - 없다면 로그인페이지로 다시 이동
	 */
	@PostMapping("login")
	public String login(HttpSession session, String id, String pw) {
		// 사용자가 입력한 id, pw가 users에 있는지 확인
		for (User user : users) {
			if (user.getId().equals(id) && user.getPw().equals(pw)) {
				// 있다면 세션에 id를 저장하고 메인페이지로 이동
				session.setAttribute("id", user.getId());
				return "index";
			}
		}

		// 아니라면 로그인페이지로 다시 이동
		return "login";
	}

	/*
	 * Q. 로그아웃 기능을 구현하기 위해 UserController에 logout 메소드를 완성하세요.
	 * - 세션에 저장된 id를 제거하고 메인페이지로 이동
	 * - *session.invalidate()을 사용하면 세션에 저장된 모든 정보를 제거할 수 있으므로 다른 방법으로 구현해보세요.
     */
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		// session.invalidate(); 
		return "redirect:/";
	}
}
