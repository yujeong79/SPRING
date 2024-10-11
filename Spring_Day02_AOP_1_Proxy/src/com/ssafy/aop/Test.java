package com.ssafy.aop;

public class Test {
	public static void main(String[] args) {
		Programmer p = new Programmer(); // Bean으로 등록됐다면 이렇게 생성 안해도 컨테이너가 알아서 생성해줄것.
		
		PersonProxy px = new PersonProxy(); // Bean으로 등록됐다면 이렇게 생성 안해도 컨테이너가 알아서 생성해줄것.
		px.setPerson(p);
		
		px.coding();
	}
}
