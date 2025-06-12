from typing import List


class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        max_distance = abs(nums[0] - nums[-1])
        for i in range(len(nums) - 1):
            distance = abs(nums[i] - nums[i + 1])
            if distance > max_distance:
                max_distance = distance
        
        return max_distance