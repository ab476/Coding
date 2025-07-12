from itertools import accumulate
from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        prefix_sum = list(accumulate(nums))
        for i in range(len(nums)):
            left_sum = prefix_sum[i - 1] if i > 0 else 0
            right_sum = prefix_sum[-1] - prefix_sum[i]
            if left_sum == right_sum:
                return i
        return -1