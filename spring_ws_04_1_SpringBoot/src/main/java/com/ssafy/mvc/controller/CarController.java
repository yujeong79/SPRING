package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Car;

@Controller
public class CarController {
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "registform";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Car car, Model model) {
		model.addAttribute("car", car);
		return "registResult";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Car> cars = new ArrayList<>();
		
		Car car1 = new Car("43도0332", "티볼리", "화이트", 148000);
		Car car2 = new Car("19오0709", "myBabyMorning", "화이트", 100000);
		Car car3 = new Car("00김0709", "myNewAvante", "화이트", 0);
		
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		
		model.addAttribute("cars", cars);
		
		return "list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") String id, Model model) {
		
		return "detail";
	}

}
