from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix_product, suffix_product = [1] * len(nums), [1] * len(nums)
        n = len(nums)
        for i in range(len(nums)):
            prefix_product[i] = prefix_product[i - 1] * nums[i] if i > 0 else nums[i]
            suffix_product[n - i - 1] = suffix_product[n - i] * nums[n - i - 1] if i > 0 else nums[n - i - 1]
        
        return [
            prefix_product[i - 1] * suffix_product[i + 1] if 0 < i < n - 1 
            else prefix_product[i - 1] if i == n - 1 
            else suffix_product[i + 1] 
            for i in range(n)
        ]