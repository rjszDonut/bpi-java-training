package com.m4_activity2;

public class ATMSystem {
    static double[] accounts = { 10000, 15000, 20000 };

    public static void main(String[] args) {
        System.out.println("=== ATM Withdrawal System ===");

        System.out.println("\n--- Test 1: Valid Withdrawal ---");
        processWithdrawal("1", "5000");

        System.out.println("\n--- Test 2: Invalid Account Index ---");
        processWithdrawal("abc", "5000");

        System.out.println("\n--- Test 3: Account Not Found ---");
        processWithdrawal("10", "5000");

        System.out.println("\n--- Test 4: Insufficient Funds ---");
        processWithdrawal("1", "20000");

        System.out.println("\n=== All tests completed! ===");

    }

    public static void processWithdrawal(String accountIndex, String amountInput) {

        System.out.println("Account=" + accountIndex + ",Amount=" + amountInput);

        try {

            int index = Integer.parseInt(accountIndex);
            double amount = Double.parseDouble(amountInput);

            double balance = accounts[index];
            System.out.println("Current Balance: ₱" + balance);
            System.out.println("Withdrawal: ₱" + amount);

            if (amount > balance) {
                System.out.println("Insufficient Funds! Cannot withdraw \u20B1" + amount);
            } else {
                Double newBalance = balance - amount;
                System.out.println("New balance: \u20B1" + newBalance);
                System.out.println("Withdrawal Successful!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error:Invalid Input!");
            System.out.println("Please enter valid numbers.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Account not found");
            System.out.println("Invalid Accountindex.");

        } catch (Exception e) {
            System.out.println("Transaction Failed");
        }
    }
}
