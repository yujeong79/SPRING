package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest4")
public class RestController4 {
	
	// http://localhost:8080/rest4/board/1
	// 위와 같은 URI 요청이 들어왔을 때 필요한 데이터를 변수로 가져오기
	@GetMapping("/board1/{id}")
	public String test1(@PathVariable int id) {
		return id + "번째 board";
	}
	
	@GetMapping("/board2/{id}")
	public String test2(@PathVariable("id") int num) {
		return num + "번째 board";
	}
	
//	@GetMapping("/board3/{id}/reviews{rid}")

}
