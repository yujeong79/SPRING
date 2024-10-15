package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller로 Bean 등록 
 * BootApplication.java의 @SpringBootApplication에 들어가보면 
 * Component-scan이 자동으로 걸려있다. 
 * 이 외에도 자동으로 등록된 수많은 Bean들이 있다.
 */
@Controller 
public class HelloController {
	
	@GetMapping("/hello") // GET 요청으로 /hello 요청이 들어오면
	public String hello(Model model) {
		model.addAttribute("msg", "Hello Boot");
		return "hello"; // prefix + hello + suffix로 포워딩
	}
	
	/**
	 * [참고] prefix와 suffix는 application.properties에 등록
	 */
}
