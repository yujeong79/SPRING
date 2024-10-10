package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {

	// //빈칸을 고려치 않고 다양한 방식으로 시도해 볼것
	 private Car car;

	 @Autowired
	 public void setCar(Car car) {
	 	this.car = car;
	 }

	 public void drive() {
	 	System.out.println(this.car.getInfo() + "를 운전합니다.");
	 }
}
