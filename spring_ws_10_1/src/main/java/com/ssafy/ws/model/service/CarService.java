package com.ssafy.ws.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Car;

public interface CarService {
	
	List<Car> selectAll();
	
	boolean regist(Car car);
	
	Car searchByVin(String vin);
	
}
