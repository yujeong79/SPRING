package com.ssafy.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.model.dto.DateDto;
import com.ssafy.ws.model.service.TestService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value= {"/", "/test"})
	public String test(HttpServletRequest request) throws Exception {
		DateDto dto = testService.test();
		// 포워드 방식으로 데이터 전달
		request.setAttribute("data", dto);
		return "index";
	}
	
}
