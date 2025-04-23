from typing import List, Optional


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        num = nums[0]
        for i in range(1, len(nums)):
            num ^= nums[i]
        # The XOR operation will cancel out all numbers that appear twice,
        return num
    

if __name__ == "__main__":
    print(Solution().singleNumber([4, 1, 2, 1, 2]))  # Output: 4
    print(Solution().singleNumber([2, 2, 1]))  # Output: 1  