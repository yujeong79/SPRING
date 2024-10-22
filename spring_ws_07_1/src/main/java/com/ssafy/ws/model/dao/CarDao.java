package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarDao {

	int insert(Car car);

	Car searchByVin(String vin);

	List<Car> selectAll();

	List<Car> searchByModelName(String modelName);

}
