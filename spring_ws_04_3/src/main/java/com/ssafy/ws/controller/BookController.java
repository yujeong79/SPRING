package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.User;

@Controller
public class BookController {

	/**
	 * <pre> / 또는 /index 요청이 get 방식으로 들어왔을 때 index 로 연결한다.</pre>
	 * 
	 * @return
	 */
	@GetMapping({"/", "/index" })
	public String showRoot() {
		return "index";
	}
	
	// 코드작성
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		if(user.getId().equals("ssafy") && user.getPassword().equals("1234")) {
			user.setName("김싸피");
			session.setAttribute("loginUser", user);
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Book> books = new ArrayList<>();
		
		Book book1 = new Book("A000001", "조앤롤링", "해리포터와 마법사의 돌", 10000, "해리포터 시리즈1", "없음");
		Book book2 = new Book("A000002", "조앤롤링", "해리포터와 비밀의 방", 10000, "해리포터 시리즈2", "없음");
		Book book3 = new Book("A000003", "조앤롤링", "해리포터와 아즈카반의 죄수", 10000, "해리포터 시리즈3", "없음");
		Book book4 = new Book("A000004", "조앤롤링", "해리포터와 불의 잔", 10000, "해리포터 시리즈4", "없음");
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		
		model.addAttribute("books", books);
		
		return "list";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Book book, Model model) {
		model.addAttribute("book", book);
		return "regist_result";
	}
	
}
