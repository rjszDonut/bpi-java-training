package com.m4_activiy4;

public class AmountValidator {

    public static void main(String[] args) {
        runTest("1234567890"); // valid example
        runTest("123");
        runTest(null);

    }

    public static void validateAccountNumber(String accountNumber) throws Exception {
        if (accountNumber == null) {
            throw new NullPointerException("Cannot be null!");
        }
        
        if (accountNumber.length() != 10) {
            throw new Exception("Must be 10 digits!");
        }
        
        System.out.println("Valid Account: " + accountNumber);
    }

    private static void runTest(String input) {
        try {
            validateAccountNumber(input);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            ;
        }

    }

}
