package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarDao {

	//자동차 등록
	int insert(Car car);
	
	//차량번호로 검색
	Car searchByVin(String vin);
	
	//자동차 목록
	List<Car> selectAll();
	
	//자동차 목록별로 검색
	List<Car> searchByModelName(String modelName);
}
