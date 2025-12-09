package com.activity6;

public class Truck extends Vehicle implements Refuelable {
    @Override
    void startEngine() {
        System.out.println("Vehicle Engine Starting...");
        
    }

    @Override
    public void refuel() {
        System.out.println("Vehicle Refueling");
        
    }
}