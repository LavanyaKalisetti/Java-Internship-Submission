package com.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private BigDecimal amount;
    private BigDecimal balanceAfterTransaction;
    private LocalDateTime dateTime;

    // Constructor
    public Transaction(String type, BigDecimal amount,
                       BigDecimal balanceAfterTransaction) {

        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.dateTime = LocalDateTime.now();
    }

    // Display transaction details
    public void displayTransaction() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Type              : " + type);
        System.out.println("Amount            : Rs. " + amount);
        System.out.println("Balance After     : Rs. "
                + balanceAfterTransaction);
        System.out.println("Date and Time     : "
                + dateTime.format(formatter));
        System.out.println("------------------------------------");
    }
}