package com.ssafy.ws.model.service;

import java.io.IOException;
import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarService {

	int insert(Car car) throws IllegalStateException, IOException;

	Car searchByVin(String vin);

	List<Car> selectAll();

	List<Car> searchByModelName(String modelName);

}
