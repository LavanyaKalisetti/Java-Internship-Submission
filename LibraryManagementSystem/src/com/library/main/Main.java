package com.library.main;

import java.util.Scanner;

import com.library.model.Book;
import com.library.service.LibraryService;

public class Main {

    // Read a valid integer
    private static int readInt(Scanner sc, String message) {

        while (true) {
            System.out.print(message);

            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }

    // Read a positive integer
    private static int readPositiveInt(Scanner sc, String message) {

        while (true) {
            int value = readInt(sc, message);

            if (value > 0) {
                return value;
            }

            System.out.println("Please enter a number greater than zero.");
        }
    }

    // Read non-empty text
    private static String readText(Scanner sc, String message) {

        while (true) {
            System.out.print(message);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService library = new LibraryService();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("      LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Display Available Books");
            System.out.println("5. Search Book By ID");
            System.out.println("6. Search Book By Title");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.println("==================================");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1: {
                    System.out.println("\n--- Add Book ---");

                    int id = readPositiveInt(sc, "Enter Book ID: ");
                    String title = readText(sc, "Enter Book Title: ");
                    String author = readText(sc, "Enter Author Name: ");
                    int copies = readPositiveInt(sc, "Enter Total Copies: ");

                    Book book = new Book(id, title, author, copies);

                    library.addBook(book);
                    break;
                }

                case 2: {
                    System.out.println("\n--- Remove Book ---");

                    int id = readPositiveInt(sc, "Enter Book ID: ");

                    library.removeBook(id);
                    break;
                }

                case 3: {
                    library.displayAllBooks();
                    break;
                }

                case 4: {
                    library.displayAvailableBooks();
                    break;
                }

                case 5: {
                    System.out.println("\n--- Search Book By ID ---");

                    int id = readPositiveInt(sc, "Enter Book ID: ");

                    library.searchBookById(id);
                    break;
                }

                case 6: {
                    System.out.println("\n--- Search Book By Title ---");

                    String title = readText(sc, "Enter Book Title: ");

                    library.searchBookByTitle(title);
                    break;
                }

                case 7: {
                    System.out.println("\n--- Issue Book ---");

                    int id = readPositiveInt(sc, "Enter Book ID: ");

                    library.issueBook(id);
                    break;
                }

                case 8: {
                    System.out.println("\n--- Return Book ---");

                    int id = readPositiveInt(sc, "Enter Book ID: ");

                    library.returnBook(id);
                    break;
                }

                case 9: {
                    System.out.println("Thank you for using the library system!");
                    break;
                }

                default: {
                    System.out.println("Invalid choice! Please select 1 to 9.");
                }
            }

        } while (choice != 9);

        sc.close();
    }
}