package com.activity6;

public class MainApp {
    public static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();

        car.startEngine();
        car.refuel();
        
        truck.startEngine();
        truck.refuel();

        destroyVehicle(car);
    }


    public static void destroyVehicle(Vehicle car) {
        car.destroy();
    }
}
