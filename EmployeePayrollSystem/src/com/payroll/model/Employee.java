
package com.payroll.model;

import java.math.BigDecimal;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String department;

    private BigDecimal basicSalary;
    private BigDecimal hra;
    private BigDecimal otherAllowances;

    // Constructor
    public Employee(int employeeId, String employeeName,
                    String department, BigDecimal basicSalary,
                    BigDecimal hra, BigDecimal otherAllowances) {

        if (employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }

        if (employeeName == null || employeeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }

        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }

        if (basicSalary == null || basicSalary.compareTo(BigDecimal.ZERO) <= 0
                || hra == null || hra.compareTo(BigDecimal.ZERO) < 0
                || otherAllowances == null
                || otherAllowances.compareTo(BigDecimal.ZERO) < 0) {

            throw new IllegalArgumentException("Invalid salary details");
        }

        this.employeeId = employeeId;
        this.employeeName = employeeName.trim();
        this.department = department.trim();
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.otherAllowances = otherAllowances;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public BigDecimal getHra() {
        return hra;
    }

    public BigDecimal getOtherAllowances() {
        return otherAllowances;
    }

    // Calculate gross salary
    public BigDecimal calculateGrossSalary() {

        return basicSalary.add(hra).add(otherAllowances);
    }

    // Display employee details
    public void displayEmployee() {

        System.out.println("------------------------------------");
        System.out.println("Employee ID      : " + employeeId);
        System.out.println("Employee Name    : " + employeeName);
        System.out.println("Department       : " + department);
        System.out.println("Basic Salary     : Rs. " + basicSalary);
        System.out.println("HRA              : Rs. " + hra);
        System.out.println("Other Allowances : Rs. " + otherAllowances);
        System.out.println("Gross Salary     : Rs. " + calculateGrossSalary());
        System.out.println("------------------------------------");
    }
}
