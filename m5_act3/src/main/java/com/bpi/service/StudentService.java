package com.bpi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.bpi.config.DBConnection;

public class StudentService {
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String courseName;
    private int grade;
    private int studentID;

    public void star() {
        Scanner sc = new Scanner(System.in);

        int choice = -1;
        do {
            displayMenu();

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            sc.nextLine();
            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> addCourse(sc);
                case 3 -> getAllStudents();
                case 4 -> getAllCourses();
                case 0 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Please choose only from 1-4.");
            }
        } while (choice != 0);

        sc.close();
    }

    public void connectToDB() {
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("Database connection is working!");
        } else {
            System.out.println("Could not connect.");
        }
    }

    public void displayMenu() {
        System.out.println("==== STUDENT COURSE MANAGEMENT ====");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Show Students");
        System.out.println("4. Show Courses");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public void addStudent(Scanner sc) {
        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        try {
            Connection conn = DBConnection.getConnection();

            if (conn == null) {
                System.err.println("Could not connect to DB. Aborting insert.");
                return;
            }

            PreparedStatement ps = conn.prepareStatement(sql);

            do {
                System.out.print("Enter name: ");
                studentName = sc.nextLine();
                if (studentName.isEmpty()) {
                    System.err.println("Name cannot be empty!");
                }

            } while (studentName.isEmpty());

            while (true) {
                System.out.print("Enter age: ");
                if (sc.hasNextInt()) {
                    studentAge = sc.nextInt();
                    sc.nextLine(); // consume leftover newline after nextInt()
                    break;
                } else {
                    System.err.println("Age invalid. Please enter a whole number.");
                    sc.nextLine(); // discard the invalid token
                }
            }

            do {
                System.out.print("Enter email: ");
                studentEmail = sc.nextLine();
                if (studentEmail.isEmpty()) {
                    System.err.println("Email cannot be empty!");
                }
            } while (studentEmail.isEmpty());

            ps.setString(1, studentName);
            ps.setInt(2, studentAge);
            ps.setString(3, studentEmail);
            ps.executeUpdate(); 

            System.out.println("Student added Successfully!\n");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void addCourse(Scanner sc) {
        String sql = "INSERT INTO courses (student_id, course_name, grade) VALUES (?, ?, ?)";
        try {
            Connection conn = DBConnection.getConnection();

            if (conn == null) {
                System.err.println("Could not connect to DB. Aborting insert.");
                return;
            }

            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.print("Enter Student ID: ");
            studentID = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course name: ");
            courseName = sc.nextLine();

            System.out.print("Enter grade: ");

            grade = sc.nextInt();
            sc.nextLine();

            // System.out.println("SID: " +
            //         studentID +
            //         "coursename: " +
            //         courseName +
            //         "grade: " + grade);
            ps.setInt(1, studentID);
            ps.setString(2, courseName);
            ps.setInt(3, grade);
          
            ps.executeUpdate();

            System.out.println("Course added Successfully!\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAllStudents() {
        String sql = "SELECT * FROM students";
        try {
            Connection conn = DBConnection.getConnection();
            if (conn == null) {
                System.err.println("Could not connect to DB. Aborting insert.");
                return;
            }

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("ID | Name | Age | Email");
            System.out.println("---------------------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("email"));
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void getAllCourses() {
        String sql = "SELECT courses.id, courses.course_name, courses.grade,students.name\r\n" + //
                "FROM students\r\n" + //
                "INNER JOIN courses ON students.id = courses.student_id;\r\n" + //
                "";
        try {
            Connection conn = DBConnection.getConnection();
            if (conn == null) {
                System.err.println("Could not connect to DB. Aborting insert.");
                return;
            }

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("ID | Course Name | Grade | Student Name");
            System.out.println("---------------------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("course_name") + " | " +
                                rs.getInt("grade") + " | " +
                                rs.getString("name"));
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
