package com.activity6;

public abstract class Vehicle {
    int numberOfWheels;
    String brand;

    abstract void startEngine();

    public void destroy() {
        System.out.println("Destroying...");
    }
}