package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.dto.Movie;

@Controller
public class MovieController {
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist") 
	public String registForm() {
		return "regist_form";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Movie movie, Model model) {
		model.addAttribute("movie", movie);
		return "regist_result";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Movie> movies = new ArrayList<>();
		
		Movie movie1 = new Movie(1, "백만엔걸 스즈코", "타나다 유키", "드라마", 121);
		Movie movie2 = new Movie(2, "불량소녀, 너를 응원해!", "도이 노부히로", "드라마", 117);
		Movie movie3 = new Movie(3, "기묘한 이야기- 맞은편 자리의 연인", "우에다 야스시", "드라마", 54);
		
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		
		model.addAttribute("movies", movies);
		
		return "list";
	}

}
