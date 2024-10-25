package com.ssafy.ws.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.model.dto.EmployeeDto;
/**
 * EmployeeService는 직원 정보를 관리하는 서비스입니다.
 * 해당 인터페이스는 EmployeeServiceImpl에서 구현됩니다.
 * why? 객체지향의 다형성을 이용하여 유연한 코드를 작성하기 위함입니다.
 */
public interface EmployeeService {

	EmployeeDto getEmployeeById(int id) throws SQLException;
	List<EmployeeDto> getAllEmployees() throws SQLException;
	int insert(EmployeeDto employee) throws SQLException;
	int update(EmployeeDto employee) throws SQLException;
	int delete(int id) throws SQLException;
}