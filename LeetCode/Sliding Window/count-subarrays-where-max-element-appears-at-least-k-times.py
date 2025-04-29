from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_count, max_num = 0, max(nums)
        left, res = 0, 0
        for i, num in enumerate(nums):
            if num == max_num:
                max_count += 1
            
            while max_count == k:
                if(nums[left] == max_num):
                    max_count -= 1
                left += 1
            res += left
        return res
           