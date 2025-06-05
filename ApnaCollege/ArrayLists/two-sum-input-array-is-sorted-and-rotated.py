# two-sum-input-array-is-sorted-and-rotated

from typing import List


def twoSum(numbers: List[int], target: int) -> List[int]:
    piviot = 0
    for i in range(len(numbers) - 1):
        if i > 0 and numbers[i] < numbers[i - 1]:
            piviot = i - 1
            break
    left, right, n = piviot + 1, piviot, len(numbers)

    while left != right:
        current_sum = numbers[left] + numbers[right]
        if current_sum == target:
            return [left + 1, right + 1]
        elif current_sum < target:
            left = (left + 1) % n
        else:
            right = (right - 1 + n) % n
    return []

# Example usage:
if __name__ == "__main__":
    numbers = [4, 5, 6, 7, 0, 1, 2]
    target = 9
    result = twoSum(numbers, target)
    print(result)  # Output: [4, 7] (1-based index)
