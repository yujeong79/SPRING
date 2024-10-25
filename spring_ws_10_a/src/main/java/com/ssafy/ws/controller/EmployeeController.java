package com.ssafy.ws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.model.dto.EmployeeDto;
import com.ssafy.ws.model.service.EmployeeService;

/**
 * EmployeeController는 직원 정보를 관리하는 컨트롤러입니다.
 * RESTful 서비스를 구현합니다.
 * 
 * - @RestController : 해당 클래스가 RESTful 서비스를 처리하는 컨트롤러임을 명시합니다.
 * - @RequestMapping : 해당 클래스의 모든 메소드에 공통적으로 적용되는 URL을 지정합니다.
 */
@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	/*
	 * ResponseEntity:
	 * ResponseEntity는 HTTP 응답을 포함하는 클래스입니다.
	 * HTTP 헤더와 상태 코드, 응답 본문을 포함합니다.
	 * 제너릭 타입을 사용하여 응답 본문의 타입을 지정하며 ResponseEntity 객체를 반환합니다.	 * 예를 들어 ResponseEntity<String>은 응답 본문이 문자열인 경우 사용합니다.
	 * 
	 * @ResponseBody가 있는 메소드의 경우, 스프링 MVC는 메소드의 반환 값을 HTTP 응답 본문으로 변환하여 클라이언트에게 전송합니다. (기본적으로 JSON 형식으로 변환)
	 * RESTful 서비스에서는 ResponseEntity 객체를 반환하는 것이 일반적입니다.
	 * 예를 들어, new ResponseEntity<>(HttpStatus.OK, employee)는 HTTP 200 상태 코드와 employee 객체를 반환합니다.
	 * 
	 * ResponseEntity는 다양한 정적 메서드를 제공합니다.
	 * - ResponseEntity.ok()는 HTTP 200 상태 코드를 반환합니다.
	 * - ResponseEntity.created()는 HTTP 201 상태 코드를 반환합니다.
	 * - ResponseEntity.noContent()는 HTTP 204 상태 코드를 반환합니다.
	 * - ...
	 */
	
	/*
	 * @RequestMapping: 해당 메소드가 처리하는 URL을 지정합니다. (HTTP 메소드에 상관없이 사용 가능하며, method 속성으로 HTTP 메소드를 지정할 수 있습니다.)
	 * @GetMapping: HTTP GET 요청을 처리하는 메소드임을 명시합니다.
	 * @PostMapping: HTTP POST 요청을 처리하는 메소드임을 명시합니다.
	 * @PutMapping: HTTP PUT 요청을 처리하는 메소드임을 명시합니다.
	 * @DeleteMapping: HTTP DELETE 요청을 처리하는 메소드임을 명시합니다.
	 */
	
	// 사원 목록 조회
	// GET /employee
	@GetMapping("")
	public ResponseEntity<?> list() throws Exception {
		List<EmployeeDto> employees = service.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	// 사원 상세 조회
	// GET /employee/{id}
	@GetMapping("/{id}")
	public ResponseEntity<?> detail(@PathVariable("id") int id) throws Exception {
		EmployeeDto employee = service.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	// 사원 등록
	// POST /employee
	@PostMapping("")
	public ResponseEntity<?> insert(EmployeeDto employee) throws Exception {
		int result = service.insert(employee);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}

	// 사원 수정
	// PUT /employee/{id}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, EmployeeDto employee) throws Exception {
		employee.setId(id);
		int result = service.update(employee);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	// 사원 삭제
	// DELETE /employee/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws Exception {
		int result = service.delete(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
	}
}
