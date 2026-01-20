package com.bpi_java;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "rjszulueta";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected successfully!");
            conn.close();

        } catch (Exception e) {

            System.out.println("Connection Failed!");

        }
    }
}