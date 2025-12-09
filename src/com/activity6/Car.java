package com.activity6;

public class Car extends Vehicle implements Refuelable {
    @Override
    void startEngine() {
        System.out.println("Car Engine Starting...");
        
    }

    @Override
    public void refuel() {
        System.out.println("Car Refueling");
        
    }

}