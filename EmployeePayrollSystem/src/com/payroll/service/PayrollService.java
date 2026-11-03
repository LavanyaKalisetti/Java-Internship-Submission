
package com.payroll.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import com.payroll.model.Employee;
import com.payroll.model.SalarySlip;

public class PayrollService {

    // Illustrative payroll configuration
    private static final BigDecimal PF_RATE =
            new BigDecimal("0.12");

    private static final BigDecimal INCOME_TAX_RATE =
            new BigDecimal("0.05");

    private static final BigDecimal PROFESSIONAL_TAX =
            new BigDecimal("200.00");

    private static final BigDecimal ZERO =
            BigDecimal.ZERO;

    // Employee records
    private List<Employee> employees = new ArrayList<>();

    // Payroll history
    private List<SalarySlip> salarySlips = new ArrayList<>();

    // Find employee by ID
    private Employee findEmployee(int employeeId) {

        for (Employee employee : employees) {

            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }

        return null;
    }

    // Add employee
    public void addEmployee(Employee employee) {

        if (findEmployee(employee.getEmployeeId()) != null) {
            System.out.println("Employee ID already exists!");
            return;
        }

        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    // Display all employees
    public void displayAllEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.println("\n========== EMPLOYEE DETAILS ==========");

        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }

    // Search employee
    public void searchEmployee(int employeeId) {

        Employee employee = findEmployee(employeeId);

        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        employee.displayEmployee();
    }

    // Calculate and generate payroll
    public void generatePayroll(int employeeId, YearMonth month) {

        Employee employee = findEmployee(employeeId);

        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        // Prevent duplicate payroll for the same employee and month
        for (SalarySlip slip : salarySlips) {

            if (slip.getEmployeeId() == employeeId
                    && slip.getPayrollMonth().equals(month)) {

                System.out.println(
                    "Payroll already generated for this employee and month!"
                );
                return;
            }
        }

        // Step 1: Calculate gross salary
        BigDecimal grossSalary =
                employee.calculateGrossSalary();

        // Step 2: Calculate PF
        BigDecimal pf = employee.getBasicSalary()
                .multiply(PF_RATE)
                .setScale(2, RoundingMode.HALF_UP);

        // Step 3: Calculate professional tax
        BigDecimal professionalTax = PROFESSIONAL_TAX;

        // Step 4: Calculate income tax
        BigDecimal incomeTax = grossSalary
                .multiply(INCOME_TAX_RATE)
                .setScale(2, RoundingMode.HALF_UP);

        // Step 5: Calculate total deductions
        BigDecimal totalDeductions = pf
                .add(professionalTax)
                .add(incomeTax);

        // Step 6: Calculate net salary
        BigDecimal netSalary = grossSalary
                .subtract(totalDeductions);

        // Validate final salary
        if (netSalary.compareTo(ZERO) < 0) {

            System.out.println(
                "Payroll cannot be generated: deductions exceed gross salary."
            );

            return;
        }

        // Step 7: Create salary slip
        SalarySlip slip = new SalarySlip(
                employee,
                grossSalary,
                pf,
                professionalTax,
                incomeTax,
                totalDeductions,
                netSalary,
                month
        );

        // Step 8: Store payroll record
        salarySlips.add(slip);

        // Step 9: Display salary slip
        System.out.println("Payroll generated successfully!");

        slip.displaySalarySlip();
    }

    // Display payroll history for an employee
    public void viewPayrollHistory(int employeeId) {

        Employee employee = findEmployee(employeeId);

        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        boolean found = false;

        System.out.println("\n========== PAYROLL HISTORY ==========");

        for (SalarySlip slip : salarySlips) {

            if (slip.getEmployeeId() == employeeId) {

                System.out.println(
                    "Month: " + slip.getPayrollMonth()
                );

                System.out.println(
                    "Net Salary: Rs. " + slip.getNetSalary()
                );

                System.out.println("------------------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No payroll history available.");
        }
    }

    // View all generated payroll records
    public void viewAllPayrolls() {

        if (salarySlips.isEmpty()) {
            System.out.println("No payroll records available.");
            return;
        }

        for (SalarySlip slip : salarySlips) {
            slip.displaySalarySlip();
        }
    }
}
