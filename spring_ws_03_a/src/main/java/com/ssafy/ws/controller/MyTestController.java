package com.ssafy.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyTestController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
