package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class K3 implements Car {
	
	public K3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInfo() {
		return "K3";
	}

}
