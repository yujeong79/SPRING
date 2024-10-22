package com.ssafy.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 메인 페이지를 보여주기 위한 컨트롤러
@Controller
public class MainController {
	@RequestMapping(value= {"/", "/main"})
	public String main() {
		return "index";
	}
}
