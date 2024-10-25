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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Minkyu;
import com.ssafy.mvc.model.service.MinkyuService;
import jakarta.servlet.http.HttpServlet;

@RestController
@RequestMapping("/minsseam")
public class MinkyuController extends HttpServlet {

	private MinkyuService service;

	public MinkyuController(MinkyuService service) {
		this.service = service;
	}
	
	@PutMapping("/minkyu/{id}")
	private ResponseEntity<?> doUpdate(@ModelAttribute Minkyu minkyu, @PathVariable("id") int id) {
		minkyu.setUserid(id);
		
		if(service.changeMinkyu(minkyu))
			return new ResponseEntity<Minkyu>(minkyu, HttpStatus.OK);
					
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/minkyu/{id}")
	private ResponseEntity<?> doRemove(@PathVariable("id") int id) {
		if(service.removeMinkyu(id))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/minkyu/{id}")
	private ResponseEntity<?> doDetail(@PathVariable("id") int id) {
		Minkyu minkyu = service.getMinkyu(id);
		
		if(minkyu != null) {
			return new ResponseEntity<Minkyu>(minkyu, HttpStatus.OK); // 200
			// return ResponseEntity.ok().body(minkyu); 
			/** ResponseEntity.ok()는 결국 ResponseEntity와 같은 객체를 반환하기 때문에 .body를 할 수 있는 것이다.*/
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
		// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("/minkyu")
	private ResponseEntity<?> doList() {
		List<Minkyu> list = service.getMinkyuList();
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Minkyu>>(list, HttpStatus.OK);
			// return ResponseEntity.ok(list);
			// return ResponseEntity.ok().body(list);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		// return ResponseEntity.status(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/minkyu")
	private ResponseEntity<?> doRegist(@ModelAttribute Minkyu minkyu) {
		if(service.registMinkyu(minkyu)) {
			return new ResponseEntity<Minkyu>(minkyu, HttpStatus.OK);
			// 반환값 ResponseEntity<String>
			// return new ResponseEntity<String>("등록 성공!", HttpStatus.CREATED);
			// return new ResponseEntity.status(HttpStatus.CREATED).body("등록 성공!");
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500번대 에러
		// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록 실패ㅠ");
	}
	
}
