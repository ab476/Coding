from itertools import accumulate


class Solution:
    def minStartValue(self, nums: list[int]) -> int:
        prefix_sum = list(accumulate(nums))
        min_start_value = 0
        for value in prefix_sum:
            if value < min_start_value:
                min_start_value = value
        return 1 - min_start_value if min_start_value < 0 else 1

        