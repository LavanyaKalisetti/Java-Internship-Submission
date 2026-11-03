
package com.payroll.main;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.payroll.model.Employee;
import com.payroll.service.PayrollService;

public class Main {

    // Read integer safely
    private static int readInt(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
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

    // Read salary amount
    private static BigDecimal readSalary(
            Scanner sc, String message, boolean allowZero) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            try {

                BigDecimal amount = new BigDecimal(input);

                if (amount.scale() > 2) {
                    System.out.println(
                        "Maximum two decimal places are allowed!"
                    );
                    continue;
                }

                if (allowZero) {

                    if (amount.compareTo(BigDecimal.ZERO) < 0) {
                        System.out.println(
                            "Amount cannot be negative!"
                        );
                        continue;
                    }

                } else {

                    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                        System.out.println(
                            "Amount must be greater than zero!"
                        );
                        continue;
                    }
                }

                return amount;

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid amount! Please enter a valid number."
                );
            }
        }
    }

    // Read payroll month
    private static YearMonth readPayrollMonth(Scanner sc) {

        while (true) {

            System.out.print("Enter Payroll Month (YYYY-MM): ");

            String input = sc.nextLine().trim();

            try {

                YearMonth month = YearMonth.parse(input);

                if (month.isAfter(YearMonth.now())) {
                    System.out.println(
                        "Future payroll months are not allowed!"
                    );
                    continue;
                }

                return month;

            } catch (DateTimeParseException e) {

                System.out.println(
                    "Invalid month! Use format YYYY-MM (Example: 2026-11)."
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PayrollService payroll = new PayrollService();

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("       EMPLOYEE PAYROLL SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Generate Salary Slip");
            System.out.println("5. View Employee Payroll History");
            System.out.println("6. View All Payroll Records");
            System.out.println("7. Exit");

            System.out.println("====================================");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1: {

                    System.out.println("\n--- Add Employee ---");

                    int id = readInt(sc, "Enter Employee ID: ");

                    String name = readText(
                            sc, "Enter Employee Name: ");

                    String department = readText(
                            sc, "Enter Department: ");

                    BigDecimal basicSalary = readSalary(
                            sc, "Enter Basic Salary: Rs. ", false);

                    BigDecimal hra = readSalary(
                            sc, "Enter HRA: Rs. ", true);

                    BigDecimal allowances = readSalary(
                            sc, "Enter Other Allowances: Rs. ", true);

                    try {

                        Employee employee = new Employee(
                                id,
                                name,
                                department,
                                basicSalary,
                                hra,
                                allowances
                        );

                        payroll.addEmployee(employee);

                    } catch (IllegalArgumentException e) {

                        System.out.println(
                            "Employee creation failed: " + e.getMessage()
                        );
                    }

                    break;
                }

                case 2: {

                    payroll.displayAllEmployees();

                    break;
                }

                case 3: {

                    System.out.println("\n--- Search Employee ---");

                    int id = readInt(sc, "Enter Employee ID: ");

                    payroll.searchEmployee(id);

                    break;
                }

                case 4: {

                    System.out.println("\n--- Generate Salary Slip ---");

                    int id = readInt(sc, "Enter Employee ID: ");

                    YearMonth month = readPayrollMonth(sc);

                    payroll.generatePayroll(id, month);

                    break;
                }

                case 5: {

                    System.out.println("\n--- Payroll History ---");

                    int id = readInt(sc, "Enter Employee ID: ");

                    payroll.viewPayrollHistory(id);

                    break;
                }

                case 6: {

                    System.out.println("\n--- All Payroll Records ---");

                    payroll.viewAllPayrolls();

                    break;
                }

                case 7: {

                    System.out.println(
                        "Thank you for using Employee Payroll System!"
                    );

                    break;
                }

                default: {

                    System.out.println(
                        "Invalid choice! Please select between 1 and 7."
                    );
                }
            }

        } while (choice != 7);

        sc.close();
    }
}
