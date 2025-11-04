"""
CISC Days 2025 – Programming Race
Problem 3: Number Analyzer (100 points)

Description:
You are to build a Number Analyzer that takes a list of integers and computes basic statistics
without using built-in functions like sum(), max(), or min().

Return a dictionary with:
    {
        "total": <sum of numbers>,
        "average": <average rounded to 2 decimals>,
        "max": <maximum number>,
        "min": <minimum number>,
        "even_count": <count of even numbers>,
        "odd_count": <count of odd numbers>
    }

If the list is empty, return None.

Parameters:
    numbers (list[int]): List of integers to analyze.
"""

def number_analyzer(numbers: list[int]) -> dict | None:
    # Implement your code below
    if not numbers:
        return None

    total = 0
    count = 0
    even_count = 0
    odd_count = 0

    current_max = numbers[0]
    current_min = numbers[0]

    for n in numbers:
        total += n
        count += 1

        if n > current_max:
            current_max = n
        if n < current_min:
            current_min = n

        if n % 2 == 0:
            even_count += 1
        else:
            odd_count += 1

    average = round(total / count, 2)

    return {
        "total": total,
        "average": average,
        "max": current_max,
        "min": current_min,
        "even_count": even_count,
        "odd_count": odd_count,
    }


if __name__ == "__main__":
    test_cases = [
        ([1, 2, 3, 4, 5],
         {"total": 15, "average": 3.0, "max": 5, "min": 1, "even_count": 2, "odd_count": 3}, 12.5),
        ([10, 20, 30],
         {"total": 60, "average": 20.0, "max": 30, "min": 10, "even_count": 3, "odd_count": 0}, 12.5),
        ([11, 13, 15],
         {"total": 39, "average": 13.0, "max": 15, "min": 11, "even_count": 0, "odd_count": 3}, 12.5),
        ([-5, 0, 5, 10],
         {"total": 10, "average": 2.5, "max": 10, "min": -5, "even_count": 2, "odd_count": 2}, 12.5),
        ([7],
         {"total": 7, "average": 7.0, "max": 7, "min": 7, "even_count": 0, "odd_count": 1}, 12.5),
        ([8],
         {"total": 8, "average": 8.0, "max": 8, "min": 8, "even_count": 1, "odd_count": 0}, 12.5),
        ([-100, 0, 50, 100],
         {"total": 50, "average": 12.5, "max": 100, "min": -100, "even_count": 4, "odd_count": 0}, 12.5),
        ([], None, 12.5),
    ]

    total_score = 0
    max_score = sum(points for _, _, points in test_cases)

    print("=== CISC Days 2025 – Programming Race ===")
    print("Problem 3: Number Analyzer\n")

    for i, (nums, expected, points) in enumerate(test_cases, 1):
        try:
            result = number_analyzer(nums)
            if result == expected:
                print(f"✅ Test {i} Passed (+{points} pts)")
                total_score += points
            else:
                print(f"❌ Test {i} Failed (Expected: {expected}, Got: {result})")
        except Exception as e:
            print(f"❌ Test {i} Error ({type(e).__name__}: {e})")

    print(f"\nTotal Score: {total_score}/{max_score}")
