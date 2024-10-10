package com.ssafy.di1_의존성개념;

public class Test {
	public static void main(String[] args) {
		// 프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
		// 프로그래머의 생성자 안에 Desktop이 생성되니까?
		Programmer p = new Programmer();
		
		p.coding();
	}
}
