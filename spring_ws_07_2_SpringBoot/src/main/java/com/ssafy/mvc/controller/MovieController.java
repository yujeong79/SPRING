package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dto.Movie;
import com.ssafy.mvc.model.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	private MovieService service;
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "movie/regist_form";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Movie movie, @RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		
		if(file != null && file.getSize() > 0) {
			movie.setOrgImg(file.getOriginalFilename());
			movie.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			
			Resource resource = resourceLoader.getResource("classpath:/static/img/");
			
			file.transferTo(new File(resource.getFile(), movie.getImg()));
		}
		
		service.insert(movie);
		model.addAttribute("movie", movie);
		
		return "movie/regist_result";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("movies", service.selectAll());
		return "movie/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		model.addAttribute("movie", service.selectById(id));
		return "movie/detail";
	}
	
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("movie", service.selectById(id));
		return "movie/update_form";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Movie movie, @RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		
		if(file != null && file.getSize() > 0) {
			movie.setOrgImg(file.getOriginalFilename());
			movie.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			
			Resource resource = resourceLoader.getResource("classpath:/static/img/");
			
			file.transferTo(new File(resource.getFile(), movie.getImg()));
		}
		
		service.update(movie);
		
		model.addAttribute("movie", movie);
		
		return "movie/regist_result";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		service.delete(id);
		return "redirect:/movie/list";
	}
	
}
