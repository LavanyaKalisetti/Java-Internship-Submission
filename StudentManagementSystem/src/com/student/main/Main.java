package com.student.main;

import java.util.Scanner;

import com.student.model.Student;
import com.student.service.StudentService;

/*
 * This is the starting point of our application.
 * It displays the menu and accepts input from the user.
*/

public class Main {
	
	    // Read integer safely
	    public static int readInt(Scanner sc, String message) {
	        while (true) {
	            System.out.print(message);

	            try {
	                return Integer.parseInt(sc.nextLine().trim());
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid integer!");
	            }
	        }
	    }

	    // Read marks safely
	    public static double readDouble(Scanner sc, String message) {
	        while (true) {
	            System.out.print(message);

	            try {
	                return Double.parseDouble(sc.nextLine().trim());
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter valid marks!");
	            }
	        }
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        StudentService service = new StudentService();

	        int choice;

	        do {
	            System.out.println("\n================================");
	            System.out.println("     STUDENT MANAGEMENT SYSTEM");
	            System.out.println("================================");
	            System.out.println("1. Add Student");
	            System.out.println("2. View All Students");
	            System.out.println("3. Search Student By ID");
	            System.out.println("4. Exit");
	            System.out.println("================================");

	            choice = readInt(sc, "Enter your choice: ");

	            switch (choice) {

	                case 1:

	                    System.out.println("\n--- Add Student ---");

	                    int id = readInt(sc, "Enter Student ID: ");

	                    System.out.print("Enter Student Name: ");
	                    String name = sc.nextLine().trim();

	                    if (name.isEmpty()) {
	                        System.out.println("Name cannot be empty!");
	                        break;
	                    }

	                    double marks = readDouble(sc, "Enter Marks: ");

	                    if (marks < 0 || marks > 100) {
	                        System.out.println("Marks must be between 0 and 100!");
	                        break;
	                    }

	                    Student student = new Student(id, name, marks);

	                    service.addStudent(student);

	                    break;

	                case 2:

	                    service.viewStudents();

	                    break;

	                case 3:

	                    System.out.println("\n--- Search Student ---");

	                    int searchId = readInt(sc, "Enter Student ID: ");

	                    service.searchStudent(searchId);

	                    break;

	                case 4:

	                    System.out.println("Thank you! Exiting application.");

	                    break;

	                default:

	                    System.out.println("Invalid choice! Please try again.");
	            }

	        } while (choice != 4);

	        sc.close();
	    }
	}

