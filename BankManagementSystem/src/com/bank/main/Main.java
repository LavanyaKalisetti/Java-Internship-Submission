package com.bank.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.bank.service.BankService;

public class Main {

    // Read integer input safely
    private static int readInt(Scanner sc, String message) {

        while (true) {
            System.out.print(message);

            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid integer.");
            }
        }
    }

    // Read a non-empty name
    private static String readName(Scanner sc, String message) {

        while (true) {
            System.out.print(message);

            String name = sc.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name cannot be empty!");
        }
    }

    // Read a valid monetary amount
    private static BigDecimal readAmount(Scanner sc, String message) {

        while (true) {
            System.out.print(message);

            String input = sc.nextLine().trim();

            try {
                BigDecimal amount = new BigDecimal(input);

                if (amount.scale() > 2) {
                    System.out.println(
                        "Please enter an amount with at most 2 decimal places."
                    );
                    continue;
                }

                return amount;

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid amount! Enter a valid monetary value."
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("       BANK MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Show Account Details");
            System.out.println("6. Transaction History");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Exit");
            System.out.println("==================================");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1: {
                    System.out.println("\n--- Create Account ---");

                    int accountNumber = readInt(
                            sc, "Enter Account Number: ");

                    String name = readName(
                            sc, "Enter Customer Name: ");

                    BigDecimal openingBalance = readAmount(
                            sc, "Enter Opening Balance: Rs. ");

                    bank.createAccount(
                            accountNumber, name, openingBalance);

                    break;
                }

                case 2: {
                    System.out.println("\n--- Deposit Money ---");

                    int accountNumber = readInt(
                            sc, "Enter Account Number: ");

                    BigDecimal amount = readAmount(
                            sc, "Enter Deposit Amount: Rs. ");

                    bank.deposit(accountNumber, amount);

                    break;
                }

                case 3: {
                    System.out.println("\n--- Withdraw Money ---");

                    int accountNumber = readInt(
                            sc, "Enter Account Number: ");

                    BigDecimal amount = readAmount(
                            sc, "Enter Withdrawal Amount: Rs. ");

                    bank.withdraw(accountNumber, amount);

                    break;
                }

                case 4: {
                    System.out.println("\n--- Check Balance ---");

                    int accountNumber = readInt(
                            sc, "Enter Account Number: ");

                    bank.checkBalance(accountNumber);

                    break;
                }

                case 5: {
                    System.out.println("\n--- Account Details ---");

                    int accountNumber = readInt(
                            sc, "Enter Account Number: ");

                    bank.showAccountDetails(accountNumber);

                    break;
                }

                case 6: {
                    System.out.println("\n--- Transaction History ---");

                    int accountNumber = readInt(
                            sc, "Enter Account Number: ");

                    bank.showTransactionHistory(accountNumber);

                    break;
                }

                case 7: {
                    bank.displayAllAccounts();
                    break;
                }

                case 8: {
                    System.out.println(
                            "Thank you for using the banking system!");
                    break;
                }

                default: {
                    System.out.println(
                            "Invalid choice! Please select 1 to 8.");
                }
            }

        } while (choice != 8);

        sc.close();
    }
}