package com.activity3;

public class Car {
	private String name;
	private String color;
	private Float speed;
	
	//	default values 
	public Car() {
		this.name = "Kotse";
		this.color = "white";
		this.speed = 60f;
	}
	
	// with parms constuctor
	public Car(String name, String color, Float speed) {
		this.name = name;
		this.color = color;
		this.speed = speed;
	}
	
	public String getCarName() {
		return this.name;
	}
	
	public void setCarName(String name) {
		this.name = name;
	}
	
	public String getCarColor() {
		return this.color;
	}
	
	public void setCarColor(String color) {
		this.color = color;
	}
	
	public Float getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
}
