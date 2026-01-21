package com.bpi;

import com.bpi.service.StudentService;

public class Main {
    public static void main(String[] args) {
            StudentService service = new StudentService();
            service.connectToDB();
            service.star();
    }

    
}