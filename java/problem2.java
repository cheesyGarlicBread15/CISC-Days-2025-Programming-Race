/*
CISC Days 2025 – Programming Race
Problem 2: Grade Evaluator (75 points)

Description:
Evaluates a student's performance based on their exam scores.

Rules:
- Compute the average manually (without using built-in sum() or list length functions).
- Assign remarks based on:
    90–100  → Excellent
    75–89   → Good
    Below 75 → Needs Improvement
- If the student gets two or more scores below 75, automatically mark as "Needs Improvement"
  even if the average is above 75.

Return:
    String - "Average = <average>, Remarks = <remarks>"
    where <average> is rounded to two decimal places.

Parameters:
    List<Integer> scores - The student's exam scores.
*/

import java.util.*;

public class problem2 {

    public static String gradeEvaluator(List<Integer> scores) {
        if (scores.isEmpty())
            return "No scores provided";

        double total = 0;
        int count = 0;
        int below75 = 0;

        for (int s : scores) {
            total += s;
            count++;
            if (s < 75)
                below75++;
        }

        double average = Math.round((total / count) * 100.0) / 100.0;
        String remarks;

        if (below75 >= 2)
            remarks = "Needs Improvement";
        else if (average >= 90 && average <= 100)
            remarks = "Excellent";
        else if (average >= 75)
            remarks = "Good";
        else
            remarks = "Needs Improvement";

        return String.format("Average = %.2f, Remarks = %s", average, remarks);
    }

    public static void main(String[] args) {
        Object[][] testCases = {
            {Arrays.asList(95, 90, 89), "Average = 91.33, Remarks = Excellent", 20},
            {Arrays.asList(80, 85, 75), "Average = 80.00, Remarks = Good", 20},
            {Arrays.asList(90, 60, 65), "Average = 71.67, Remarks = Needs Improvement", 20},
            {Collections.emptyList(), "No scores provided", 15}
        };

        double totalScore = 0;
        double maxScore = 0;
        for (Object[] test : testCases)
            maxScore += (int) test[2];

        System.out.println("=== CISC Days 2025 – Programming Race ===");
        System.out.println("Problem 2: Grade Evaluator\n");

        for (int i = 0; i < testCases.length; i++) {
            @SuppressWarnings("unchecked")
            List<Integer> scores = (List<Integer>) testCases[i][0];
            String expected = (String) testCases[i][1];
            double points = (int) testCases[i][2];

            try {
                String result = gradeEvaluator(scores);
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
