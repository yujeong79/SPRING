package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;

@Controller
public class UserController {
	
	@GetMapping("/regist")
	public String registform() {
		return "regist";
	}
	
//	@PostMapping("/regist")
//	public String regist(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		
//		User user = new User(id, pw);
//		
//		System.out.println(user);
//		
//		return "result";
//	}
	
	/** 위를 @ModelAttribute를 사용해서 이렇게 편리하게 받을 수 있음 */
	/** dto를 준비해놓고 @ModelAttribute를 하면 알아서 생성자를 통해서 생성을 함 */
	/** request 안에 parameter와 setter의 이름이 같으면 spring이 알아서 넣어주는거징... */
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user) {		
		System.out.println(user);
		
		return "result";
	}
}
