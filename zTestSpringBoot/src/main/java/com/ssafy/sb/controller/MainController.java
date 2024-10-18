package com.ssafy.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index"; // forward 방식이 기본, prefix와 suffix가 붙어서 /WEB-INF/views/index.jsp가 된다.
	}
	
}
