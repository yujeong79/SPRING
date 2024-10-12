package com.ssafy.ws;

import java.util.Random;

public class Driver implements Person{

	@Override
	public void doSomething() throws GasException { // target 메서드
		System.out.println("열심히 운전을 합니다.");
		
		//예외발생코드
		if(new Random().nextBoolean()) {
			throw new GasException();
		}
	}
	

}
