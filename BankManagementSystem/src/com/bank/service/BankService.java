package com.bank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;

public class BankService {

    private List<Account> accounts = new ArrayList<>();

    // Find account by account number
    private Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    // Create a new account
    public void createAccount(int accountNumber, String customerName,
                              BigDecimal openingBalance) {

        if (accountNumber <= 0) {
            System.out.println("Account number must be positive.");
            return;
        }

        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        if (openingBalance == null
                || openingBalance.compareTo(BigDecimal.ZERO) < 0) {

            System.out.println("Opening balance cannot be negative.");
            return;
        }

        if (findAccount(accountNumber) != null) {
            System.out.println("Account number already exists.");
            return;
        }

        Account account = new Account(
                accountNumber,
                customerName.trim(),
                openingBalance
        );

        accounts.add(account);

        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
    }

    // Deposit money
    public void deposit(int accountNumber, BigDecimal amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
            System.out.println("Updated Balance: Rs. "
                    + account.getBalance());
        }
    }

    // Withdraw money
    public void withdraw(int accountNumber, BigDecimal amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount.compareTo(account.getBalance()) > 0) {
            System.out.println("Insufficient balance!");
            return;
        }

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
            System.out.println("Updated Balance: Rs. "
                    + account.getBalance());
        }
    }

    // Check balance
    public void checkBalance(int accountNumber) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Account Number: "
                + account.getAccountNumber());

        System.out.println("Current Balance: Rs. "
                + account.getBalance());
    }

    // Display account details
    public void showAccountDetails(int accountNumber) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.displayAccountDetails();
    }

    // Display transaction history
    public void showTransactionHistory(int accountNumber) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Account Number: "
                + account.getAccountNumber());

        account.displayTransactionHistory();
    }

    // Display all accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n========== ALL ACCOUNTS ==========");

        for (Account account : accounts) {
            account.displayAccountDetails();
        }
    }
}