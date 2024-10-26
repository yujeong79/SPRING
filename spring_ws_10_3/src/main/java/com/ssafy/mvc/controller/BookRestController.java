package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Book;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.BookService;
import com.ssafy.mvc.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="book-rest-controller", description="Book Rest Controller")
@RequestMapping("/bookapi")
public class BookRestController {
	
	private BookService bService;
	private UserService uService;
	
	public BookRestController(BookService bService, UserService uService) {
		this.bService = bService;
		this.uService = uService;
	}
	
	@GetMapping("/book")
	@Operation(summary="query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환한다.")
	public ResponseEntity<?> searchByCondition(@ModelAttribute SearchCondition condition) { // queryString으로 보내도 @ModelAttribute로 binding 할 수 있다.	
		List<Book> list = bService.searchByCondition(condition);
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping("/book")
	@Operation(summary="Book 객체를 저장한다.")
	public ResponseEntity<?> registBook(@RequestBody Book book) {
		if(bService.registBook(book)) {
			return new ResponseEntity<Book>(book, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("너는 요청을 잘못보냈다!!", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/book")
	@Operation(summary="Book 객체를 수정한다.")
	public ResponseEntity<?> modifyBook(@RequestBody Book book) {
		if(bService.modifyBook(book)) {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("업데이트 실패잉~!", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/book/{isbn}")
	@Operation(summary="{isbn}에 해당하는 도서 정보를 반환한다.")
	public ResponseEntity<?> searchByIsbn(@PathVariable("isbn") String isbn) {
		Book book = bService.searchByIsbn(isbn);
		
		if(book != null) {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/book/{isbn}")
	@Operation(summary="Book 객체를 삭제한다.")
	public ResponseEntity<String> removeByIsbn(@PathVariable("isbn") String isbn) {
		if(bService.removeBook(isbn)) {
			return new ResponseEntity<String>("삭제 성공!!", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("삭제 실패ㅜ", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/user/{id}")
	@Operation(summary="{id}에 해당하는 사용자 정보를 반환한다.")
	public ResponseEntity<?> searchById(@PathVariable("id") String id) {
		User user = uService.searchById(id);
		
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
