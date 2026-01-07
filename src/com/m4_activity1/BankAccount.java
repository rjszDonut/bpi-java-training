package com.m4_activity1;

public class BankAccount {

    public static void main(String[] args) {
        System.out.println("=== Bank Account Name Display ===");

        testCase("ACC-001");
        testCase("ACC-999");

        System.out.println("\n=== Program Compeleted Successfully! ===");

    }

    public static String getAccountName(String accountNumber) {
        System.out.println("\nLooking up account: " + accountNumber);
        if (accountNumber.equals("ACC-001")) {
            return "Juan Dela Cruz";

        } else if (accountNumber.equals("ACC-002")) {
            return "Maria Santos";
        } else {
            return null;
        }
    }

    public static void testCase(String accountNumber) {
        try {
            String name = getAccountName(accountNumber);

            name.toUpperCase();

            System.out.println("Account holder: " + name);
        } catch (NullPointerException e) {
            System.out.println("Error: Account not found!");
        }
    }
}
