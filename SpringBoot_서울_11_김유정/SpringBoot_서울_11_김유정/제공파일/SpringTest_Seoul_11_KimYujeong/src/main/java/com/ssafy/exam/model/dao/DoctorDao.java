package com.ssafy.exam.model.dao;

import java.util.List;

import com.ssafy.exam.model.dto.Doctor;

public interface DoctorDao {
    int insertDoctor(Doctor doctor);
    
    List<Doctor> selectAllDoctors();
    
    Doctor selectDoctorById(int id);
    
    int updateDoctor(Doctor doctor);
    
    int deleteDoctor(int id);
}
