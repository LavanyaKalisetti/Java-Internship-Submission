package com.bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private int accountNumber;
    private String customerName;
    private BigDecimal balance;

    private List<Transaction> transactions = new ArrayList<>();

    // Constructor
    public Account(int accountNumber, String customerName,
                   BigDecimal openingBalance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = openingBalance;

        // Record account opening
        transactions.add(
            new Transaction("ACCOUNT OPENED",
                    openingBalance, balance)
        );
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    // Deposit money
    public boolean deposit(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        balance = balance.add(amount);

        transactions.add(
            new Transaction("DEPOSIT", amount, balance)
        );

        return true;
    }

    // Withdraw money
    public boolean withdraw(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        if (amount.compareTo(balance) > 0) {
            return false;
        }

        balance = balance.subtract(amount);

        transactions.add(
            new Transaction("WITHDRAWAL", amount, balance)
        );

        return true;
    }

    // Display account details
    public void displayAccountDetails() {

        System.out.println("\n========== ACCOUNT DETAILS ==========");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Balance        : Rs. " + balance);
        System.out.println("=====================================");
    }

    // Display transaction history
    public void displayTransactionHistory() {

        if (transactions.isEmpty()) {
            System.out.println("No transaction history available.");
            return;
        }

        System.out.println("\n======= TRANSACTION HISTORY =======");

        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
        }
    }

    // Return an unmodifiable view of transaction history
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}