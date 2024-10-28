package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/doctor")
@Tag(name="doctor-rest-controller")
public class DoctorRestController {
	
	private DoctorService dService;
	
	public DoctorRestController(DoctorService dService) { // DoctorService 의존성 주입
		this.dService = dService;
	}

	// Post 요청이 들어오면 addDoctor 메서드 수행
	@PostMapping
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		if(dService.addDoctor(doctor)) {
			return new ResponseEntity<String>("Doctor added successfully", HttpStatus.CREATED);
		}
		
		// doctor 삽입이 실패한 경우
		return new ResponseEntity<String>("Failed to add doctor", HttpStatus.INTERNAL_SERVER_ERROR); 
	}

	// Get 요청이 들어오면 getAllDoctors 메서드 수행
	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> list = dService.getAllDoctors();
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);
		}
		
		// list가 비어있는 경우 조회 실패
		return ResponseEntity.noContent().build();
	}
	
	// id와 함께 Get 요청이 들어오면 getDoctorById 메서드 수행 
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int id) {
		Doctor doctor = dService.getDoctorById(id);
		
		if(doctor != null) {
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		}

		return ResponseEntity.notFound().build();
	}

	// id와 함께 Put 요청이 들어오면 updateDoctor 메서드 수행
	@PutMapping("/{id}")
	public ResponseEntity<String> updateDoctor(@PathVariable("id") int id, @RequestBody Doctor doctor) {
		doctor.setDoctorId(id);
		
		if(dService.updateDoctor(doctor)) {
			return new ResponseEntity<String>("Doctor updated successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Failed to update doctor", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// id와 함께 Delete 요청이 들어오면 deleteDoctor 메서드 수행
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") int id) {
		if(dService.deleteDoctor(id)) {
			return new ResponseEntity<String>("Doctor deleted successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Failed to delete doctor", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
