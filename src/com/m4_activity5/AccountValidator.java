package com.m4_activity5;

public class AccountValidator {

    public static void main(String[] args) {
        System.out.println("=== Account Number Validation Test ===");
        testValidation("\nTest 1: Valid account ", "1234567890");
        testValidation("\nTest 2: Too Short ", "123");
        testValidation("\nTest 3: Contains Letters ", "12345ABC90");
        testValidation("\nTest 4: Contains Spaces", "1234 567890");
        testValidation("\nTest 5: Null Value ", null);

    }

    public static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if (accountNumber == null) {
            throw new NullPointerException("Warning: Account number cannot be null!");
        }

        for (char c : accountNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidAccountFormatException("Warning: Account number must contain only Digits!");
            }
        }

        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Error: Account Number Must be exactly 10 digits!");
        }

        System.out.println("Valid Account Number: " + accountNumber);
    }

    public static void testValidation(String testName, String accountNumber) {
        try {
            // System.out.println(testName + "(" + accountNumber + ")");

            String header = (accountNumber == null)
                    ? testName
                    : testName + "(" + accountNumber + ")";
            System.out.println(header);

            validateAccountNumber(accountNumber);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
