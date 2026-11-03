
package com.quiz.model;

public class QuizResult {

    private String participantName;
    private int totalQuestions;
    private int correctAnswers;
    private int wrongAnswers;
    private double percentage;

    // Constructor
    public QuizResult(String participantName,
                      int totalQuestions,
                      int correctAnswers) {

        this.participantName = participantName;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;

        this.wrongAnswers = totalQuestions - correctAnswers;

        this.percentage =
                (correctAnswers * 100.0) / totalQuestions;
    }

    // Display final result
    public void displayResult() {

        System.out.println("\n====================================");
        System.out.println("             QUIZ RESULT");
        System.out.println("====================================");

        System.out.println("Participant Name : " + participantName);
        System.out.println("Total Questions  : " + totalQuestions);
        System.out.println("Correct Answers  : " + correctAnswers);
        System.out.println("Wrong Answers    : " + wrongAnswers);
        System.out.println("Total Score      : " +
                correctAnswers + "/" + totalQuestions);

        System.out.printf("Percentage       : %.2f%%\n", percentage);

        System.out.println("------------------------------------");

        if (percentage >= 80) {

            System.out.println("Grade            : Excellent");

        } else if (percentage >= 60) {

            System.out.println("Grade            : Good");

        } else if (percentage >= 40) {

            System.out.println("Grade            : Average");

        } else {

            System.out.println("Grade            : Needs Improvement");
        }

        if (percentage >= 40) {
            System.out.println("Result           : PASS");
        } else {
            System.out.println("Result           : FAIL");
        }

        System.out.println("====================================");
    }

    // Getters for result history
    public String getParticipantName() {
        return participantName;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public double getPercentage() {
        return percentage;
    }
}
