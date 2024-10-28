package com.ssafy.exam.model.dao;

import com.ssafy.exam.model.dto.Specialty;

public interface SpecialtyDao {
    int insertSpecialty(Specialty specialty);
   
    Specialty selectSpecialtyByCode(int code);
    
    int deleteSpecialty(int code);
}
