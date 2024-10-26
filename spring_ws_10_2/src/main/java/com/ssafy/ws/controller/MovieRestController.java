package com.ssafy.ws.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.MovieService;
import com.ssafy.ws.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/movieapi")
@CrossOrigin("*")
@Tag(name="SSAFY 영화관리 API", description="워크샵에서 사용되는 RestApi에 대한 문서를 제공한다.")
public class MovieRestController {
	
	private MovieService movieService;
	
	private UserService userService;
	
	
	public MovieRestController(MovieService movieService, UserService userService) {
		this.movieService = movieService;
		this.userService = userService;
	}
	
	@GetMapping("/movie")
	@Operation(summary="등록된 모든 영화 정보를 반환한다.")
	public ResponseEntity<?> list() {
		List<Movie> list = movieService.getList();
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/movie")
	@Operation(summary="movie 객체를 저장한다.")
	public ResponseEntity<?> regist(@RequestBody Movie movie) {
		System.out.println(movie.toString());
		if(movieService.regist(movie)) {
			return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/movie/{id}")
	@Operation(summary="movie 객체를 삭제한다.")
	public ResponseEntity<String> remove(@PathVariable("id") int id) {
		if(movieService.remove(id)) {
			return new ResponseEntity<String>("movie 삭제 성공", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("movie 삭제 실패", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/movie/{title}")
	@Operation(summary="{title}에 해당하는 영화 정보를 반환한다.")
	public ResponseEntity<?> searchByTitle(@PathVariable("title") String title) {
		List<Movie> list = movieService.searchByTitle(title);
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/user/{id}")
	@Operation(summary="{id}에 해당하는 user를 반환한다.")
	public ResponseEntity<?> searchById(@PathVariable("id") String id) {
		User user = userService.searchById(id);
		
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
