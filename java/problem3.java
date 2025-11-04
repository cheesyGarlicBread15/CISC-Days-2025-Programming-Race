/*
CISC Days 2025 – Programming Race
Problem 3: Number Analyzer (100 points)

Description:
You are to build a Number Analyzer that takes a list of integers and computes basic statistics
without using built-in functions like sum(), max(), or min().

Return:
    A Map<String, Object> containing:
        "total"      : <sum of numbers>,
        "average"    : <average rounded to 2 decimals>,
        "max"        : <maximum number>,
        "min"        : <minimum number>,
        "even_count" : <count of even numbers>,
        "odd_count"  : <count of odd numbers>
    If the list is empty, return null.

Parameters:
    numbers (List<Integer>) : List of integers to analyze.
*/

import java.util.*;

public class problem3 {

    public static Map<String, Object> numberAnalyzer(List<Integer> numbers) {
        // Implement your code below
        if (numbers.isEmpty())
            return null;

        int total = 0, count = 0;
        int evenCount = 0, oddCount = 0;
        int currentMax = numbers.get(0);
        int currentMin = numbers.get(0);

        for (int n : numbers) {
            total += n;
            count++;

            if (n > currentMax)
                currentMax = n;
            if (n < currentMin)
                currentMin = n;

            if (n % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        double average = Math.round((total / (double) count) * 100.0) / 100.0;

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("total", total);
        result.put("average", average);
        result.put("max", currentMax);
        result.put("min", currentMin);
        result.put("even_count", evenCount);
        result.put("odd_count", oddCount);

        return result;
    }

    public static void main(String[] args) {
        Object[][] testCases = {
                { Arrays.asList(1, 2, 3, 4, 5),
                        Map.of("total", 15, "average", 3.0, "max", 5, "min", 1, "even_count", 2, "odd_count", 3),
                        12.5 },
                { Arrays.asList(10, 20, 30),
                        Map.of("total", 60, "average", 20.0, "max", 30, "min", 10, "even_count", 3, "odd_count", 0),
                        12.5 },
                { Arrays.asList(11, 13, 15),
                        Map.of("total", 39, "average", 13.0, "max", 15, "min", 11, "even_count", 0, "odd_count", 3),
                        12.5 },
                { Arrays.asList(-5, 0, 5, 10),
                        Map.of("total", 10, "average", 2.5, "max", 10, "min", -5, "even_count", 2, "odd_count", 2),
                        12.5 },
                { Arrays.asList(7),
                        Map.of("total", 7, "average", 7.0, "max", 7, "min", 7, "even_count", 0, "odd_count", 1), 12.5 },
                { Arrays.asList(8),
                        Map.of("total", 8, "average", 8.0, "max", 8, "min", 8, "even_count", 1, "odd_count", 0), 12.5 },
                { Arrays.asList(-100, 0, 50, 100),
                        Map.of("total", 50, "average", 12.5, "max", 100, "min", -100, "even_count", 4, "odd_count", 0),
                        12.5 },
                { Collections.emptyList(), null, 12.5 }
        };

        double totalScore = 0;
        double maxScore = 0;
        for (Object[] test : testCases)
            maxScore += (double) test[2];

        System.out.println("=== CISC Days 2025 – Programming Race ===");
        System.out.println("Problem 3: Number Analyzer\n");

        for (int i = 0; i < testCases.length; i++) {
            @SuppressWarnings("unchecked")
            List<Integer> nums = (List<Integer>) testCases[i][0];
            @SuppressWarnings("unchecked")
            Map<String, Object> expected = (Map<String, Object>) testCases[i][1];
            double points = (double) testCases[i][2];

            try {
                Map<String, Object> result = numberAnalyzer(nums);
                if (Objects.equals(result, expected)) {
                    System.out.printf("✅ Test %d Passed (+%.1f pts)%n", i + 1, points);
                    totalScore += points;
                } else {
                    System.out.printf("❌ Test %d Failed (Expected: %s, Got: %s)%n", i + 1, expected, result);
                }
            } catch (Exception e) {
                System.out.printf("❌ Test %d Error (%s: %s)%n", i + 1, e.getClass().getSimpleName(), e.getMessage());
            }
        }

        System.out.printf("%nTotal Score: %.1f/%.1f%n", totalScore, maxScore);
    }
}
