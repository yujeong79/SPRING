package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;
import com.ssafy.hw.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Tag(name="SSAFY 사용자관리 API", description="과제에서 사용되는 RestApi에 대한 문서를 제공한다.")
public class UserRestController {

	private UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	@Operation(summary="등록된 모든 사용자 정보를 반환한다.")
	public ResponseEntity<?> list() {
		List<User> list = userService.selectAll();
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/user")
	@Operation(summary="사용자 정보를 삽입한다.")
	public ResponseEntity<?> regist(@ModelAttribute User user) {
		if(userService.regist(user)) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/user/{id}")
	@Operation(summary="{id}에 해당하는 사용자 정보를 반환한다.")
	public ResponseEntity<?> searchById(@PathVariable("id") String id) {
		User user = userService.searchById(id);
		
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/user/search")
	@Operation(summary="SearchCondition에 부합하는 조건을 가진 사용자 목록을 반환한다.")
	public ResponseEntity<?> searchByCondition(@ModelAttribute SearchCondition condition) {
		List<User> list = userService.searchByCondition(condition);
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
