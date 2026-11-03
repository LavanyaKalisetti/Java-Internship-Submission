package com.library.service;

import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;

public class LibraryService {

    // Store all books in an ArrayList
    private List<Book> books = new ArrayList<>();

    // Find a book using its ID
    private Book findBookById(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    // Add a new book
    public void addBook(Book book) {

        if (findBookById(book.getId()) != null) {
            System.out.println("Error: Book ID already exists!");
            return;
        }

        books.add(book);

        System.out.println("Book added successfully!");
    }

    // Remove a book using its ID
    public void removeBook(int id) {

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.hasIssuedCopies()) {
            System.out.println(
                "Cannot remove this book because copies are currently issued."
            );
            return;
        }

        books.remove(book);

        System.out.println("Book removed successfully!");
    }

    // Display all books
    public void displayAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("\n========== LIBRARY BOOKS ==========");

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Display only books with available copies
    public void displayAvailableBooks() {

        boolean found = false;

        System.out.println("\n========== AVAILABLE BOOKS ==========");

        for (Book book : books) {

            if (book.getAvailableCopies() > 0) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently available.");
        }
    }

    // Search by book ID
    public void searchBookById(int id) {

        Book book = findBookById(id);

        if (book != null) {
            System.out.println("\nBook found:");
            book.displayBook();
        } else {
            System.out.println("Book not found!");
        }
    }

    // Search by title
    public void searchBookByTitle(String title) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {

                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with that title.");
        }
    }

    // Issue a book
    public void issueBook(int id) {

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.issueCopy()) {
            System.out.println("Book issued successfully!");
            System.out.println("Available copies: "
                    + book.getAvailableCopies());
        } else {
            System.out.println("No copies available to issue.");
        }
    }

    // Return a book
    public void returnBook(int id) {

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.returnCopy()) {
            System.out.println("Book returned successfully!");
            System.out.println("Available copies: "
                    + book.getAvailableCopies());
        } else {
            System.out.println("No issued copies to return.");
        }
    }
}