package com.ssafy.ws.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class Car {

	private String vin;
	private String modelName;
	private String color;
	private int mileage;
	// 중복 파일을 방지하기 위해 img에 prefix를 추가한 이름
	private String img;
	// 파일 업로드를 처리하기 위해 MultipartFile을 추가한다.
	private MultipartFile file;
	// 클라이언트가 최초 업로드한 파일 이름
	private String orgImg;

	public Car() {
	}

	public Car(String vin, String modelName, String color, int mileage, String img) {
		this(vin, modelName, color, mileage, img, null);
	}

	public Car(String vin, String modelName, String color, int mileage, String img, MultipartFile file) {
		this.vin = vin;
		this.modelName = modelName;
		this.color = color;
		this.mileage = mileage;
		this.img = img;
		this.file = file;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", modelName=" + modelName + ", color=" + color + ", mileage=" + mileage + ", img="
				+ img + ", file=" + file + ", orgImg=" + orgImg + "]";
	}

}
