from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left, right = 0, 0
        current_sum = nums[0] if nums else 0
        min_length = len(nums) + 1
        while right < len(nums):
            if current_sum < target:
                right += 1
                if right < len(nums):
                    current_sum += nums[right]
            else:
                while current_sum >= target and left <= right:
                    min_length = min(min_length, right - left + 1)
                    current_sum -= nums[left]
                    left += 1
        return min_length if min_length != len(nums) + 1 else 0