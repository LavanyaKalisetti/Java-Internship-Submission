package com.student.service;

import java.util.ArrayList;

import com.student.model.Student;

/*
 * This class contains the main business logic.
 
   It handles:
      - Adding student records.
      - Displaying all students.
      - Searching students by ID.
      - Preventing duplicate student IDs.
 
 */

public class StudentService {
	
	private ArrayList<Student> students = new ArrayList<>();
	
	public void addStudent(Student student) {
		
		for(Student s :students) {
			if(s.getId() == student.getId()) {
				System.out.println("Student ID already exists!");
				return;
			}
		}
		
		students.add(student);
        System.out.println("Student added successfully!");

	}
	
	public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        System.out.println("\n----- Student Details -----");

        for (Student s : students) {
            s.displayStudent();
        }
    }
	
	public void searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                System.out.println("\nStudent Found!");
                s.displayStudent();
                return;
            }
        }

        System.out.println("Student not found!");

     }
}
