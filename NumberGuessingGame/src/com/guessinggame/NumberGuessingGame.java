package com.guessinggame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		Random random = new Random();
		
		boolean playAgain = true;

        System.out.println("==================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("==================================");
        
        
        while (playAgain) {

            // Step 1: Generate a random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;

            // Step 2: Initialize attempt counter
            int attempts = 0;

            int guess = 0;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("Can you guess the number?");

            // Step 3: Continue until the correct number is guessed
            while (guess != randomNumber) {

                System.out.print("Enter your guess: ");

                // Validate the user's input
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.nextLine();
                    continue;
                }

                guess = sc.nextInt();

                // Check the allowed range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                // Count valid guesses
                attempts++;

                // Step 4: Compare the guess with the random number
                if (guess < randomNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("\nCongratulations! You guessed correctly.");
                    System.out.println("The correct number is: " + randomNumber);
                    System.out.println("Total attempts: " + attempts);
                }
            }

            // Step 5: Ask whether the user wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");

            String response = sc.next();

            if (response.equalsIgnoreCase("yes")) {
                playAgain = true;
            } else {
                playAgain = false;
                System.out.println("\nThank you for playing!");
                System.out.println("Game over!");
            }
        }

        sc.close();
	}

}
