package com.student.model;

//This class represents a student and stores their ID, name and marks.

public class Student {
	
	private int id;
	private String name;
	private double marks;
	
	public Student(int id,String name,double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}

	public void displayStudent() {
		System.out.println("Student ID : " + id);
		System.out.println("Student Name : " + name);
		System.out.println("Student Marks : " + marks);
	}

}
