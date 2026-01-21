package com.bpi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "rjszulueta";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // System.out.println("Connected to training_db.");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace(); // shows the real reason
            return null;
        }
    }

}