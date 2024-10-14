package com.ssafy.ws;

import java.util.Random;

public class Audience implements Person{

	@Override
	public void doSomething() throws CallException {
		System.out.println("영화를 봅니다.");
		
		if(new Random().nextBoolean()) {
			throw new CallException();
		}
		
	}
	
}
