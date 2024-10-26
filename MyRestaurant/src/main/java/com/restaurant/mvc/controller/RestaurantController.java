package com.restaurant.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.mvc.model.dto.Restaurant;
import com.restaurant.mvc.model.dto.SearchCondition;
import com.restaurant.mvc.model.service.RestaurantService;

import jakarta.servlet.annotation.MultipartConfig;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	private RestaurantService rService;
	
	public RestaurantController(RestaurantService rService) {
		this.rService = rService;
	}
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		SearchCondition condition = new SearchCondition();
		
		model.addAttribute("restaurants", rService.searchByCondition(condition));
		return "/restaurant/list";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "/restaurant/registForm";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Restaurant restaurant, @RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		if(file != null && file.getSize() > 0) {
			restaurant.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			restaurant.setOrgImg(file.getOriginalFilename());
			
			Resource resource = resourceLoader.getResource("classpath:/static/img/"); // classpath : src/main/resources/static/img/
			
			file.transferTo(new File(resource.getFile(), restaurant.getImg()));
		}
		
		rService.registRestaurant(restaurant);
		
		return "redirect:/restaurant/registResult?id="+restaurant.getId();
	}
	
	@GetMapping("/registResult")
	public String registResult(@PathVariable("id") int id, Model model) {
		model.addAttribute("restaurant", rService.searchById(id)); 
		
		return "/restaurant/registResult";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		model.addAttribute("restaurant", rService.searchById(id)); 
		
		return "/restaurant/detail";
	}
	
	@GetMapping("/modify")
	public String modifyForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("restaurant", rService.searchById(id)); 
		
		return "/restaurant/modifyForm";		
	}
	
	@PostMapping("/modify")
	public String modify(@ModelAttribute Restaurant restaurant, Model model) {
		rService.modifyRestaurant(restaurant);
		
		return "redirect:/restaurant/detail?id="+restaurant.getId();
	}
	
}
