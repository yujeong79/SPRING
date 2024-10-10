package com.ssafy.di4_의존성주입;

public class ComputerFactory {
	public static Computer getComputer(String type) {
		if(type.equals("D")) return new Desktop();
		else if(type.equals("L")) return new Laptop();
		return null;
	}
}
