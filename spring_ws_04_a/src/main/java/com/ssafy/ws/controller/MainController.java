package com.ssafy.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	// 모든 요청에 대해 AInterceptor, BInterceptor, CInterceptor가 적용된다.
	@GetMapping("/")
	public String index() {
		System.out.println("index 핸들러 메소드 실행");
		return "index";
	}
	
	// 모든 요청에 대해 AInterceptorA만 제외하고 나머지 BInterceptor, CInterceptor가 적용된다.
	@GetMapping("/exclude_a")
	public String exclude_a() {
		System.out.println("exclude_a 핸들러 메소드 실행");
		return "index";
	}
	
	// 모든 요청에 대해 BInterceptor, CInterceptor만 제외하고 AInterceptor가 적용된다.
	@GetMapping("/exclude_bc")
	public String exclude_bc() {
		System.out.println("exclude_bc 핸들러 메소드 실행");
		return "index";
	}
}
