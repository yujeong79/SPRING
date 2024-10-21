package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.ws.model.dto.EmployeeDto;
import com.ssafy.ws.model.service.EmployeeService;

/**
 * EmployeeController는 직원 정보를 관리하는 컨트롤러입니다.
 *
 * - "/" 혹은 "/main" 접속 시, 모든 직원의 목록을 조회합니다.
 * - "/detail/{id}" 접속 시, 해당 id의 직원의 상세 정보를 조회합니다.
 * - "/create"에 GET 요청 시, 직원 등록 페이지로 이동합니다.
 * - "/create"에 POST 요청 시, 새 직원을 등록합니다.
 * - "/{id}/update"에 GET 요청 시, 해당 id의 직원 정보를 수정하는 페이지로 이동합니다.
 * - "/{id}/update"에 POST 요청 시, 해당 id의 직원 정보를 수정합니다.
 * - "/{id}/delete"에 접속 시, 해당 id의 직원을 삭제합니다.
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	// 사원 목록 조회
	@RequestMapping(value= {"/", "/main"})
	public String list(Model model) throws Exception {
		List<EmployeeDto> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}
	
	// 사원 상세 조회
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") int id, Model model) throws Exception {
		EmployeeDto employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "detail";
	}
	
	// 사원 등록 페이지로 이동
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String create() {
		return "create";
	}
	
	// 사원 등록
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String insert(EmployeeDto employee) throws Exception {
		service.insert(employee);
		return "redirect:/main";
	}
	
	// 사원 수정 페이지로 이동
	@RequestMapping(value="/{id}/update", method = RequestMethod.GET)
	public String update(@PathVariable("id") int id, Model model) throws Exception {
		EmployeeDto employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update";
	}

	// 사원 수정
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(@PathVariable("id") int id, EmployeeDto employee) throws Exception {
		employee.setId(id);
		service.update(employee);
		// 상세 페이지로 이동
		return "redirect:/detail/" + employee.getId();
	}

	// 사원 삭제
	@RequestMapping("{id}/delete")
	public String delete(@PathVariable("id") int id) throws Exception {
		service.delete(id);
		return "redirect:/main";
	}
}
