package com.m4_activity3;

public class ATMTransaction {
    public static void main(String[] args) {
        System.out.println("=== ATM BALANCE INQUIRY SYSTEM ===");

        System.out.println("\n--- Test 1: Valid Savings Account ---");
        checkBalance("100123456", 1500.00);

        System.out.println("\n--- Test 2: Valid Checking Account ---");
        checkBalance("200987654", 25000.00);

        System.out.println("\n--- Test 3: Invalid Account Number Format ---");
        checkBalance("ABCD12345", 15000.00);

        System.out.println("\n--- Test 4: Empty Account Number ---");
        checkBalance("", 15000.00);

    }

    public static void checkBalance(String accountNumber, double balance) {
        try {
            System.out.println("Processing balance inquiry...");

            int accNumberparsed = Integer.parseInt(accountNumber);
            char accountType = accountNumber.charAt(0);

            // checking of account type
            if (accountType == '1') {
                System.out.println("Account Type: Savings");
            } else if (accountType == '2') {
                System.out.println("Account Type: Checking");
            } else {
                System.out.println("Account Type: Unknown");
            }

            System.out.println("Account Number: " + accNumberparsed);
            System.out.println("Current Balance: \u20B1" + balance);
            System.out.println("Balance Inquiry Successful! ");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Account Number format! Account numbers must be numeric ");

        }catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Account Number is empty or invalid!");

        } finally  {
            System.out.println("\n==========RECEIPT=========");
            System.out.println("Transaction Date: December 3, 2025");
            System.out.println("Transaction Type: Balance Inquiry");
            System.out.println("ATM Location: Main Branch");
            System.out.println("Thank you for banking with us!");
            System.out.println("============================");

        }
    }
}
