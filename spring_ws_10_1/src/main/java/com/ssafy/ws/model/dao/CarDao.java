package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarDao {
	
	List<Car> selectAll();
	
	int insert(Car car);
	
	Car selectByVin(String vin);
	
}
