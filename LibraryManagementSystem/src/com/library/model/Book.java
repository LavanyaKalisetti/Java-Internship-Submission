package com.library.model;

public class Book {

    private int id;
    private String title;
    private String author;
    private int totalCopies;
    private int issuedCopies;

    // Constructor
    public Book(int id, String title, String author, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.issuedCopies = 0;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getIssuedCopies() {
        return issuedCopies;
    }

    // Calculate available copies
    public int getAvailableCopies() {
        return totalCopies - issuedCopies;
    }

    // Issue one copy
    public boolean issueCopy() {
        if (getAvailableCopies() > 0) {
            issuedCopies++;
            return true;
        }

        return false;
    }

    // Return one copy
    public boolean returnCopy() {
        if (issuedCopies > 0) {
            issuedCopies--;
            return true;
        }

        return false;
    }

    // Check whether copies are currently issued
    public boolean hasIssuedCopies() {
        return issuedCopies > 0;
    }

    // Display book details
    public void displayBook() {
        System.out.println("--------------------------------");
        System.out.println("Book ID          : " + id);
        System.out.println("Title            : " + title);
        System.out.println("Author           : " + author);
        System.out.println("Total Copies     : " + totalCopies);
        System.out.println("Issued Copies    : " + issuedCopies);
        System.out.println("Available Copies : " + getAvailableCopies());
        System.out.println("--------------------------------");
    }
}