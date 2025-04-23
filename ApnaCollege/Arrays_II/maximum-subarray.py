from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = 0
        max_sum = None
        for num in nums:
            if sum < 0:
                sum = 0
            sum += num
            if max_sum is None or sum > max_sum:
                max_sum = sum
        return max_sum if max_sum is not None else 0