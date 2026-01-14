package com.activity8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {
    private final Logger logger = LoggerFactory.getLogger(BankAccount.class);
    private double balance = 10000.00;

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        logger.info("Withdrawal requested: ₱{}", amount);

        if (amount < 0) {
            logger.error("ERROR");
            throw new InvalidAmountException("Withdrawal failed: Insufficient funds for wtihdrawal!");
        }

        if (amount > balance) {
            logger.warn("Insufficient funds: ₱{} available", balance);
            throw new InsufficientFundsException("Insufficient funds for wtihdrawal!", balance, amount);
        }

        balance -= amount;
        logger.info("Withdrawal completed: ₱{} New Balance: ₱{}",amount, balance);
    };

    public void deposit(double amount) throws InvalidAmountException, InsufficientFundsException {
        logger.info("Deposit requested: ₱{}", amount);

        if (amount <= 0) {
            logger.error("Invalid deposit amount: ₱{}", amount);
            throw new InvalidAmountException("Deposit amount must be positive");
        }

        if (amount > 50000) {
            logger.warn("Large deposit: ₱{} - requires verification", amount);
        }

        balance += amount;
        logger.info("Deposit completed: ₱{}, New balance: ₱{}",amount, balance);
    };


}
