
package com.payroll.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class SalarySlip {

    private Employee employee;

    private BigDecimal grossSalary;
    private BigDecimal pf;
    private BigDecimal professionalTax;
    private BigDecimal incomeTax;
    private BigDecimal totalDeductions;
    private BigDecimal netSalary;

    private YearMonth payrollMonth;
    private LocalDate generatedDate;

    // Constructor
    public SalarySlip(Employee employee,
                      BigDecimal grossSalary,
                      BigDecimal pf,
                      BigDecimal professionalTax,
                      BigDecimal incomeTax,
                      BigDecimal totalDeductions,
                      BigDecimal netSalary,
                      YearMonth payrollMonth) {

        this.employee = employee;
        this.grossSalary = grossSalary;
        this.pf = pf;
        this.professionalTax = professionalTax;
        this.incomeTax = incomeTax;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
        this.payrollMonth = payrollMonth;
        this.generatedDate = LocalDate.now();
    }

    public int getEmployeeId() {
        return employee.getEmployeeId();
    }

    public YearMonth getPayrollMonth() {
        return payrollMonth;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    // Display salary slip
    public void displaySalarySlip() {

        System.out.println("\n==========================================");
        System.out.println("             EMPLOYEE SALARY SLIP");
        System.out.println("==========================================");

        System.out.println("Employee ID    : " + employee.getEmployeeId());
        System.out.println("Employee Name  : " + employee.getEmployeeName());
        System.out.println("Department     : " + employee.getDepartment());

        System.out.println("Payroll Month  : " + payrollMonth);
        System.out.println("Generated Date : " + generatedDate);

        System.out.println("------------------------------------------");
        System.out.println("                 EARNINGS");
        System.out.println("------------------------------------------");

        System.out.println("Basic Salary   : Rs. " + employee.getBasicSalary());
        System.out.println("HRA            : Rs. " + employee.getHra());
        System.out.println("Other Allowance: Rs. " + employee.getOtherAllowances());

        System.out.println("------------------------------------------");
        System.out.println("Gross Salary   : Rs. " + grossSalary);

        System.out.println("\n                 DEDUCTIONS");
        System.out.println("------------------------------------------");

        System.out.println("PF             : Rs. " + pf);
        System.out.println("Professional Tax: Rs. " + professionalTax);
        System.out.println("Income Tax     : Rs. " + incomeTax);

        System.out.println("------------------------------------------");
        System.out.println("Total Deductions: Rs. " + totalDeductions);

        System.out.println("==========================================");
        System.out.println("NET SALARY     : Rs. " + netSalary);
        System.out.println("==========================================");
    }
}
