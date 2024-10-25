package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.EmployeeDto;

/**
 * EmployeeDao는 직원 정보를 관리하는 DAO입니다.
 * DAO는 Data Access Object의 약자로, 데이터베이스에 직접 접근하는 객체입니다.
 * MyBatis를 사용하여 SQL을 실행하고, 결과를 반환합니다.
 * 
 * 인터페이스로 선언되어 있으며, 직원 정보를 조회, 삽입, 수정, 삭제하는 메소드를 포함합니다.
 * 이는 매핑 파일인 EmployeeMapper.xml에 정의된 SQL을 실행합니다.
 * (메서드명과 SQL 아이디가 일치해야 합니다.)
 */
public interface EmployeeDao {
    List<EmployeeDto> selectAll();
    EmployeeDto selectOne(int id);
    int insert(EmployeeDto employee);
    int update(EmployeeDto employee);
    int delete(int id);
}
