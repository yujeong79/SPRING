package com.ssafy.proxy;

public class OuchException extends RuntimeException{
	public void handleException() {
		System.out.println("아프니까 병원가자ㅠ");
	}
}
