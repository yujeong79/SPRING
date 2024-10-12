package com.ssafy.ws;

public class CarAspect {
	public void before() {
		System.out.println("차를 탑니다.");
	}
	public void after_rt() {
		System.out.println("주차를 합니다.");
	}
	public void after_th() {
		System.out.println("주유소에 가서 기름을 넣습니다.");
	}
	public void after() {
		System.out.println("차에서 내립니다.");
	}
}
