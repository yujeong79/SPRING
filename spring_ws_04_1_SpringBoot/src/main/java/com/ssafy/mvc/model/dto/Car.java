package com.ssafy.mvc.model.dto;

public class Car {
	String id;
	String model;
	String color;
	int mileage;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String id, String model, String color, int mileage) {
		super();
		this.id = id;
		this.model = model;
		this.color = color;
		this.mileage = mileage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", color=" + color + ", mileage=" + mileage + "]";
	}
	
}
