"""
CISC Days 2025 – Programming Race
Problem 2: Grade Evaluator (75 points)

Create a program that evaluates a student's performance based on their exam scores.

Rules:
- Compute the average manually (without using sum() or len()).
- Assign remarks based on:
    90–100  → Excellent
    75–89   → Good
    Below 75 → Needs Improvement
- If the student gets two or more scores below 75, automatically mark as "Needs Improvement"
  even if the average is above 75.

Return:
    "Average = <average>, Remarks = <remarks>"
where <average> is rounded to two decimal places.

Parameters:
    scores (list[int]): The student's exam scores.
"""

def grade_evaluator(scores: list[int]) -> str:
    # Implement your code below
    if not scores:
        return "No scores provided"

    total = 0
    count = 0
    below_75 = 0

    for s in scores:
        total += s
        count += 1
        if s < 75:
            below_75 += 1

    average = round(total / count, 2)

    if below_75 >= 2:
        remarks = "Needs Improvement"
    elif 90 <= average <= 100:
        remarks = "Excellent"
    elif 75 <= average < 90:
        remarks = "Good"
    else:
        remarks = "Needs Improvement"

    return f"Average = {average:.2f}, Remarks = {remarks}"


if __name__ == "__main__":
    test_cases = [
        ([95, 90, 89], "Average = 91.33, Remarks = Excellent", 20),
        ([80, 85, 75], "Average = 80.00, Remarks = Good", 20),
        ([90, 60, 65], "Average = 71.67, Remarks = Needs Improvement", 20),
        ([], "No scores provided", 15),
    ]

    total_score = 0
    max_score = sum(points for _, _, points in test_cases)

    print("=== CISC Days 2025 – Programming Race ===")
    print("Problem 2: Grade Evaluator\n")

    for i, (scores, expected, points) in enumerate(test_cases, 1):
        try:
            result = grade_evaluator(scores)
            if result == expected:
                print(f"✅ Test {i} Passed (+{points} pts)")
                total_score += points
            else:
                print(f"❌ Failed (Expected: {expected}, Got: {result})")
        except Exception as e:
            print(f"❌ Error occurred: {type(e).__name__} ({e})")

    print(f"\nTotal Score: {total_score}/{max_score}")