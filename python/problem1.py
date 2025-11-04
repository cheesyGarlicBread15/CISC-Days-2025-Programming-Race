"""
CISC Days 2025 – Programming Race
Problem 1: Lucky Guess (50 points)

Create a program that simulates a player guessing a secret number between 1 and 10.

Rules:
- Only the first 3 valid guesses (numbers within 1–10) count as attempts.
- Invalid guesses are ignored.
- If the player guesses the number within 3 valid attempts, print "You win!".
- Otherwise, print "You lose! The number was X".

Return:
    "You win!" or "You lose! The number was X"

Parameters:
    guesses (list[int]): Numbers guessed by the player.
    number (int): The secret number to be guessed.
"""

def lucky_guess(guesses: list[int], number: int) -> str:
    # Implement your code below
    attempts = 0
    for guess in guesses:
        if guess < 1 or guess > 10:
            continue
        attempts += 1
        if guess == number:
            return "You win!"
        if attempts == 3:
            break
    return f"You lose! The number was {number}"


if __name__ == "__main__":
    test_cases = [
        ([3, 7, 5], 5, "You win!", 15),
        ([0, 11, 14, 10], 10, "You win!", 15),
        ([1, 11, 2, 3, 4, 5], 6, "You lose! The number was 6", 10),
        ([12, 15, 20], 7, "You lose! The number was 7", 10),
    ]

    total_score = 0
    max_score = sum(points for _, _, _, points in test_cases)

    print("=== CISC Days 2025 – Programming Race ===")
    print("Problem 1: Lucky Guess\n")

    for i, (guesses, number, expected, points) in enumerate(test_cases, 1):
        result = lucky_guess(guesses, number)
        if result == expected:
            print(f"✅ Test {i} Passed (+{points} pts)")
            total_score += points
        else:
            print(f"❌ Test {i} Failed (Expected: {expected}, Got: {result})")

    print(f"\nTotal Score: {total_score}/{max_score}")
