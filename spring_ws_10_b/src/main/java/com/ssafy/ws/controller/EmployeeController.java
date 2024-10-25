package com.ssafy.ws.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.model.dto.EmployeeDto;
import com.ssafy.ws.model.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.*;

/**
 * EmployeeController는 직원 정보를 관리하는 컨트롤러입니다.
 * RESTful 서비스를 구현합니다.
*/
// Q1. Swagger 태그를 이용하여 EmployeeController에 대한 설명을 작성하세요.
@Tag(name = "Employee", description = "직원 정보 관리")
@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	// 사원 목록 조회
	// GET /employee
	// Q2. Swagger 어노테이션을 이용하여 사원 목록 조회에 대한 설명을 작성하세요.
	@Operation(summary = "직원 목록 조회", description = "모든 직원의 정보를 조회합니다.")
	@GetMapping("")
	public ResponseEntity<?> list() throws Exception {
		List<EmployeeDto> employees = service.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	// 사원 상세 조회
	// GET /employee/{id}
	// Q3. Swagger 어노테이션을 이용하여 사원 상세 조회에 대한 설명을 작성하세요.
	@Operation(summary = "직원 상세 조회", description = "직원의 상세 정보를 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<?> detail(@PathVariable("id") int id) throws Exception {
		EmployeeDto employee = service.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	// 사원 등록
	// POST /employee
	// Q4. Swagger 어노테이션을 이용하여 사원 등록에 대한 설명을 작성하세요.
	@Operation(summary = "직원 등록", description = "직원의 정보를 등록합니다.")
	@PostMapping("")
	public ResponseEntity<?> insert(@Parameter(description = "직원 정보", required = true)
			EmployeeDto employee) throws Exception {
		int result = service.insert(employee);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}

	// 사원 수정
	// PUT /employee/{id}
	// Q5. Swagger 어노테이션을 이용하여 사원 수정에 대한 설명을 작성하세요.
	@Operation(summary = "직원 수정", description = "직원의 정보를 수정합니다.")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Parameter(description = "직원 정보", required = true)
			EmployeeDto employee) throws Exception {
		employee.setId(id);
		int result = service.update(employee);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	// 사원 삭제
	// DELETE /employee/{id}
	// Q6. Swagger 어노테이션을 이용하여 사원 삭제에 대한 설명을 작성하세요.
	@Operation(summary = "직원 삭제", description = "직원의 정보를 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws Exception {
		int result = service.delete(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
	}
}
