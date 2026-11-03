
package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.quiz.model.Question;
import com.quiz.model.QuizResult;

public class QuizService {

    // Store questions
    private List<Question> questions = new ArrayList<>();

    // Store quiz history
    private List<QuizResult> results = new ArrayList<>();

    // Constructor
    public QuizService() {
        loadQuestions();
    }

    // Add predefined questions
    private void loadQuestions() {

        questions.add(new Question(
                1,
                "Which language is platform independent?",
                "C",
                "Java",
                "Python",
                "C++",
                'B'
        ));

        questions.add(new Question(
                2,
                "Which keyword is used to inherit a class in Java?",
                "implements",
                "extends",
                "inherits",
                "super",
                'B'
        ));

        questions.add(new Question(
                3,
                "Which method is the entry point of a Java program?",
                "start()",
                "run()",
                "main()",
                "execute()",
                'C'
        ));

        questions.add(new Question(
                4,
                "Which collection allows duplicate elements?",
                "Set",
                "Map",
                "List",
                "None",
                'C'
        ));

        questions.add(new Question(
                5,
                "Which keyword is used to create an object?",
                "class",
                "new",
                "this",
                "static",
                'B'
        ));

        questions.add(new Question(
                6,
                "Which of these is not an OOP concept?",
                "Inheritance",
                "Polymorphism",
                "Encapsulation",
                "Compilation",
                'D'
        ));

        questions.add(new Question(
                7,
                "Which package contains the Scanner class?",
                "java.io",
                "java.util",
                "java.lang",
                "java.sql",
                'B'
        ));

        questions.add(new Question(
                8,
                "Which keyword prevents method overriding?",
                "static",
                "private",
                "final",
                "abstract",
                'C'
        ));

        questions.add(new Question(
                9,
                "Which interface is used to sort objects naturally?",
                "Runnable",
                "Comparable",
                "Serializable",
                "Cloneable",
                'B'
        ));

        questions.add(new Question(
                10,
                "Which exception occurs when dividing an integer by zero?",
                "IOException",
                "NullPointerException",
                "ArithmeticException",
                "NumberFormatException",
                'C'
        ));
    }

    // Start quiz
    public void startQuiz(Scanner sc, String participantName) {

        int score = 0;

        System.out.println("\n====================================");
        System.out.println("           JAVA QUIZ");
        System.out.println("====================================");

        System.out.println("Participant: " + participantName);
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Each question carries 1 mark.");
        System.out.println("------------------------------------");

        // Loop through all questions
        for (Question question : questions) {

            question.displayQuestion();

            char answer;

            // Validate user answer
            while (true) {

                System.out.print("Enter your answer (A/B/C/D): ");

                String input = sc.nextLine().trim();

                if (input.length() == 1) {

                    answer = Character.toUpperCase(
                            input.charAt(0));

                    if ("ABCD".indexOf(answer) != -1) {
                        break;
                    }
                }

                System.out.println(
                        "Invalid answer! Please enter A, B, C or D."
                );
            }

            // Check answer
            if (answer == question.getCorrectAnswer()) {

                System.out.println("Correct Answer!");
                score++;

            } else {

                System.out.println("Wrong Answer!");

                System.out.println(
                        "Correct Answer: " +
                        question.getCorrectAnswer()
                );
            }

            System.out.println("------------------------------------");
        }

        // Generate final result
        QuizResult result = new QuizResult(
                participantName,
                questions.size(),
                score
        );

        // Store result
        results.add(result);

        // Display result
        result.displayResult();
    }

    // Display all quiz results
    public void viewQuizHistory() {

        if (results.isEmpty()) {

            System.out.println("No quiz results available.");

            return;
        }

        System.out.println("\n========== QUIZ HISTORY ==========");

        for (QuizResult result : results) {

            System.out.println(
                    "Participant: " +
                    result.getParticipantName()
            );

            System.out.println(
                    "Score: " +
                    result.getCorrectAnswers()
            );

            System.out.printf(
                    "Percentage: %.2f%%\n",
                    result.getPercentage()
            );

            System.out.println("----------------------------------");
        }
    }
}
