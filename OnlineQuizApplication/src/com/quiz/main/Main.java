
package com.quiz.main;

import java.util.Scanner;

import com.quiz.service.QuizService;

public class Main {

    // Read non-empty name
    private static String readName(Scanner sc) {

        while (true) {

            System.out.print("Enter Participant Name: ");

            String name = sc.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name cannot be empty!");
        }
    }

    // Read menu choice
    private static int readChoice(Scanner sc) {

        while (true) {

            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Enter a valid number."
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QuizService quizService = new QuizService();

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("         ONLINE QUIZ APPLICATION");
            System.out.println("====================================");

            System.out.println("1. Start Quiz");
            System.out.println("2. View Quiz History");
            System.out.println("3. Exit");

            System.out.println("====================================");

            choice = readChoice(sc);

            switch (choice) {

                case 1: {

                    System.out.println("\n--- Start Quiz ---");

                    String name = readName(sc);

                    quizService.startQuiz(sc, name);

                    break;
                }

                case 2: {

                    System.out.println("\n--- Quiz History ---");

                    quizService.viewQuizHistory();

                    break;
                }

                case 3: {

                    System.out.println(
                            "Thank you for using Online Quiz Application!"
                    );

                    break;
                }

                default: {

                    System.out.println(
                            "Invalid choice! Please select 1 to 3."
                    );
                }
            }

        } while (choice != 3);

        sc.close();
    }
}
