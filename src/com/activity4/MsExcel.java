package com.activity4;

public class MsExcel implements Executable {
//	implemented methods from Executable interface
    public void run() {
        System.out.println("Opening MS Excel...");
    }

    public void stop() {
        System.out.println("Stopping MS Excel...");
    }

//    concrete method
    public void sayHello(){
        System.out.println("Hello from Excel");
    }
}
