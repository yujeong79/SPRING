package com.ssafy.exam.model.service;

import com.ssafy.exam.model.dto.Specialty;

public interface SpecialtyService {
	boolean addSpecialty(Specialty specialty);

	Specialty getSpecialtyByCode(int code);

	boolean deleteSpecialty(int code);
}