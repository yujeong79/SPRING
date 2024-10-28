package com.ssafy.exam.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

// SpecialtyService 인터페이스의 구현체 

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
	
	private SpecialtyDao dao;
	
	public SpecialtyServiceImpl(SpecialtyDao dao) { // SpecialtyDao 의존성 주입
		this.dao = dao;
	}

	@Override
	public boolean addSpecialty(Specialty specialty) { 
		return dao.insertSpecialty(specialty) > 0; // specialty 객체를 삽입한 결과 1개 이상의 데이터 삽입이 성공하면 true를 반환 아니면 false 반환
	}

	@Override
	public Specialty getSpecialtyByCode(int code) {
		return dao.selectSpecialtyByCode(code); // code를 통해 specialty 객체를 조회해서 해당 객체 반환
	}

	@Override
	public boolean deleteSpecialty(int code) {
		return dao.deleteSpecialty(code) > 0; // specialty 객체를 삭제한 결과 1개 이상의 데이터 삭제가 성공하면 true 아니면 false 반환
	}

}
