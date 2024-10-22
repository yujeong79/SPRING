package com.ssafy.ws.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.model.dao.*;
import com.ssafy.ws.model.dto.*;

@Controller
public class EmployeeDynamicTestController {
	
	@Autowired
    private EmployeeDao employeeDao;
	
    @RequestMapping(value={"/test1", "/"})
	public String test1(Model model) {
    	Employee employee = new Employee();
    	employee.setPosition("과장");
    	List<Employee> employees = employeeDao.selectByCondition(employee);
		model.addAttribute("employees", employees);
    	return "test1";
	}
    
    @RequestMapping("/test2")
	public String test2(Model model) {
		List<Employee> employees = employeeDao.selectByCase("position");
		model.addAttribute("employees", employees);
		return "test2";
	}
    
    @RequestMapping("/test3")
    public String test3(Model model) {
    	List<Employee> employees = employeeDao.selectByMultipleIds(Arrays.asList(1, 3, 5));
    	model.addAttribute("employees", employees);
        return "test3";
    }
}
