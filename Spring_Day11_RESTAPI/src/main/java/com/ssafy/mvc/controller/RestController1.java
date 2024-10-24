package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;

@Controller
public class RestController1 {

	@GetMapping("/rest1/test1")
	public String test1() {
		return "Hello REST API";
	}
	
	@GetMapping("/rest1/test2")
	@ResponseBody
	public String test2() {
		return "Hello REST API";
	}
	
	
	// 사용자 정보를 Map 객체로 넘겨주는 메서드
	@GetMapping("/rest1/test3")
	@ResponseBody
	public Map<String, String> test3() {
		Map<String, String> data = new HashMap<>();
		data.put("id", "ssafy");
		data.put("pw", "1234");
		return data; // 잭슨이 알아서 JSON 데이터로 변환해준다.
	}
	
	// 사용자 정보를 User 객체로 넘겨주는 메서드
	@GetMapping("/rest1/test4")
	@ResponseBody
	public User test4() {
		User user = new User("ssafy", "1234", "김싸피");
		return user;
	}
	
	// 사용자 정보를 List 객체로 넘겨주는 메서드
	@GetMapping("/rest1/test5")
	@ResponseBody
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafyKim", "1234", "김싸피"));
		list.add(new User("ssafyLee", "1234", "이싸피"));
		list.add(new User("ssafyPark", "1234", "박싸피"));
		list.add(new User("ssafyChoi", "1234", "최싸피"));
		return list;
	}
}
