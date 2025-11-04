/*
CISC Days 2025 – Programming Race
Problem 1: Lucky Guess (50 points)

Description:
Create a program that simulates a player guessing a secret number between 1 and 10.

Rules:
- Only the first 3 valid guesses (numbers within 1–10) count as attempts.
- Invalid guesses are ignored.
- If the player guesses the number within 3 valid attempts, return "You win!".
- Otherwise, return "You lose! The number was X".

Return:
    String - "You win!" or "You lose! The number was X"

Parameters:
    List<Integer> guesses - Numbers guessed by the player.
    int number            - The secret number to be guessed.
*/

import java.util.*;

public class problem1 {

    public static String luckyGuess(List<Integer> guesses, int number) {
        // Implement your code below
        return "";
    }

    public static void main(String[] args) {
        Object[][] testCases = {
            {Arrays.asList(3, 7, 5), 5, "You win!", 15},
            {Arrays.asList(0, 11, 14, 10), 10, "You win!", 15},
            {Arrays.asList(1, 11, 2, 3, 4, 5), 6, "You lose! The number was 6", 10},
            {Arrays.asList(12, 15, 20), 7, "You lose! The number was 7", 10}
        };

        double totalScore = 0;
        double maxScore = 0;
        for (Object[] test : testCases)
            maxScore += (int) test[3];

        System.out.println("=== CISC Days 2025 – Programming Race ===");
        System.out.println("Problem 1: Lucky Guess\n");

        for (int i = 0; i < testCases.length; i++) {
            @SuppressWarnings("unchecked")
            List<Integer> guesses = (List<Integer>) testCases[i][0];
            int number = (int) testCases[i][1];
            String expected = (String) testCases[i][2];
            double points = (int) testCases[i][3];

            try {
                String result = luckyGuess(guesses, number);
                if (result.equals(expected)) {
                    System.out.printf("✅ Test %d Passed (+%.0f pts)%n", i + 1, points);
                    totalScore += points;
                } else {
                    System.out.printf("❌ Test %d Failed (Expected: %s, Got: %s)%n", i + 1, expected, result);
                }
            } catch (Exception e) {
                System.out.printf("❌ Test %d Error (%s: %s)%n", i + 1, e.getClass().getSimpleName(), e.getMessage());
            }
        }

        System.out.printf("%nTotal Score: %.0f/%.0f%n", totalScore, maxScore);
    }
}
