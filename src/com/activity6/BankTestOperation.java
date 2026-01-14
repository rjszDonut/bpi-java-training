package com.activity6;

@FunctionalInterface
public interface BankTestOperation {
    void execute() throws InvalidAmountException, InsufficientFundsException;
}
