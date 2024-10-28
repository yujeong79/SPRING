package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

// DoctorService 인터페이스의 구현체

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorDao dao; 
	
	public DoctorServiceImpl(DoctorDao dao) { // DoctorDao 생성자 의존성 주입
		this.dao = dao;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		return dao.insertDoctor(doctor) > 0; // Doctor 객체를 삽입한 결과 1개 이상 데이터 삽입이 성공하면 true 아니면 false 반환
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return dao.selectAllDoctors(); // 모든 doctor 조회해서 List<Doctor> 반환
	}

	@Override
	public Doctor getDoctorById(int id) {
		return dao.selectDoctorById(id); // 해당하는 id를 통해 doctor 객체 조회해서 해당 객체 반환
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		return dao.updateDoctor(doctor) > 0; // Doctor 객체를 수정한 결과 1개 이상 데이터 수정이 성공하면 true 아니면 false 반환
	}

	@Override
	public boolean deleteDoctor(int id) {
		return dao.deleteDoctor(id) > 0; // Doctor 객체를 삭제한 결과 1개 이상 데이터 삭제가 성공하면 true 아니면 false 반환
	}

}
