package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.CarDao;
import com.ssafy.ws.model.dto.Car;

@Service
public class CarServiceImpl implements CarService {

	private CarDao dao;
	
	public CarServiceImpl(CarDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Car> selectAll() {
		return dao.selectAll();
	}

	@Override
	public boolean regist(Car car) {
		return dao.insert(car) > 0;
	}

	@Override
	public Car searchByVin(String vin) {
		return dao.selectByVin(vin);
	}

}
