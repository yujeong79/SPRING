package com.ssafy.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/specialty")
@Tag(name="specialty-rest-controller")
public class SpecialtyRestController {
	
	private SpecialtyService sService;
	
	public SpecialtyRestController(SpecialtyService sService) { // SpecialtyService 의존성 주입
		this.sService = sService;
	}

	// Post 요청이 들어오면 addSpecialty 메서드 수행
	@PostMapping
    public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
    	if(sService.addSpecialty(specialty)) {
    		return new ResponseEntity<String>("Specialty added successfully", HttpStatus.CREATED);
    	}
    	
    	return new ResponseEntity<String>("Failed to add specialty", HttpStatus.INTERNAL_SERVER_ERROR);
    }

	// code와 함께 Get 요청이 들어오면 getSpecialty 메서드 수행 
	@GetMapping("/{code}")
    public ResponseEntity<Specialty> getSpecialty(@PathVariable("code") int code) {
    	Specialty specialty = sService.getSpecialtyByCode(code);
    	
    	if(specialty != null) {
    		return new ResponseEntity<Specialty>(specialty, HttpStatus.OK);
    	}
    	
    	return ResponseEntity.notFound().build();
    }

	// code와 함게 Delete 요청이 들어오면 deleteSpecialty 메서드 수행
	@DeleteMapping("/{code}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable("code") int code) {
    	if(sService.deleteSpecialty(code)) {
    		return new ResponseEntity<String>("Specialty deleted successfully", HttpStatus.CREATED);
    	}
    	
    	return new ResponseEntity<String>("Failed to delete specialty", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}