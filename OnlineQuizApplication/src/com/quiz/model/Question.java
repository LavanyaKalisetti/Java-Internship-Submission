
package com.quiz.model;

public class Question {

    private int questionId;
    private String questionText;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private char correctAnswer;

    // Constructor
    public Question(int questionId, String questionText,
                    String optionA, String optionB,
                    String optionC, String optionD,
                    char correctAnswer) {

        if (questionId <= 0) {
            throw new IllegalArgumentException(
                    "Question ID must be positive");
        }

        if (questionText == null || questionText.trim().isEmpty()
                || optionA == null || optionB == null
                || optionC == null || optionD == null) {

            throw new IllegalArgumentException(
                    "Question and options cannot be empty");
        }

        correctAnswer = Character.toUpperCase(correctAnswer);

        if ("ABCD".indexOf(correctAnswer) == -1) {
            throw new IllegalArgumentException(
                    "Correct answer must be A, B, C or D");
        }

        this.questionId = questionId;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    // Display question and options
    public void displayQuestion() {

        System.out.println("\nQ" + questionId + ". " + questionText);

        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
    }
}
