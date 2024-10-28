package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-user")
public class UserRestController {
	private final UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	// 사용자 목록 전체 가져오기
	@GetMapping("/users")
	public ResponseEntity<List<User>> userList() {
		List<User> list = userService.getUserList();
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);			
		}
		
		return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);			
	}
	
	// 사용자 회원가입
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@ModelAttribute User user) {
		if(userService.signup(user)) {
			return new ResponseEntity<String>("회원가입 성공", HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(@ModelAttribute User user, HttpSession session) {
		User loginUser = userService.login(user.getId(), user.getPassword());
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser.getName());
			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		session.getAttribute("loginUser");
		
		return new ResponseEntity<String>("로그아웃 성공", HttpStatus.OK);
	}
}
