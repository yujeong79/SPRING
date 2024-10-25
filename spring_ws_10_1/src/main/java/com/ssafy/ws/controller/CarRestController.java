package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Car;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.CarService;
import com.ssafy.ws.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/carapi")
@CrossOrigin("*")
@Tag(name="SSAFY 자동차관리 API", description="워크샵에서 사용되는 RestApi에 대한 문서를 제공한다.")
public class CarRestController {
	
	private CarService carService;
	
	private UserService userService;
	
	@Autowired
	public CarRestController(CarService carService, UserService userService) {
		this.carService = carService;
		this.userService = userService;
	}

	@GetMapping("/car")
	@Operation(summary="등록된 모든 자동차 정보를 반환한다.")
	public ResponseEntity<?> list() {
		List<Car> list = carService.selectAll();
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Car>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/car")
	@Operation(summary="Car 객체를 저장한다.")
	public ResponseEntity<?> regist(@ModelAttribute Car car) {
		if(carService.regist(car))
			return new ResponseEntity<>(HttpStatus.CREATED); // 생성 
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/car/{vin}")
	@Operation(summary="{vin}에 해당하는 자동차 정보를 반환한다.")
	public ResponseEntity<?> searchByVin(@PathVariable("vin") String vin) {
		Car car = carService.searchByVin(vin);
		
		if(car != null) {
			return new ResponseEntity<>(car, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@GetMapping("/user/{id}")
	@Operation(summary="{id}에 해당하는 user를 반환한다.")
	public ResponseEntity<?> searchById(@PathVariable("id") String id) {
		User user = userService.searchById(id);
		
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
}
