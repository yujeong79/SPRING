package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.dto.Car;

@Controller
public class CarController {
	
	@GetMapping("/regist")
	public String registForm() {
		return "registForm";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Car car, Model model) {
		model.addAttribute("car", car);
		
		return "regist_result";
	}
	
}
