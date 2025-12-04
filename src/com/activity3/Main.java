package com.activity3;

public class Main {


	public static void main(String[] args) {
//		Default constructor used
		Car jeep = new Car();
		
		String carName1 = jeep.getCarName();
		System.out.println("First car name: " + carName1);

//		Constructor with parameter
		Car toyota = new Car("Innova", "Grey", 60f);
		
		String carName2 = toyota.getCarName();
		System.out.println("Second car name: " + carName2);
		
		toyota.setCarName("Avanza");
		String newCarname = toyota.getCarName();
		System.out.println("Second car new name: " + newCarname);
		
	}

}
