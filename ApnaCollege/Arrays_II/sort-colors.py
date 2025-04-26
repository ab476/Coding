from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zeros, ones, twos = 0, 0, 0
        for num in nums:
            match num:
                case 0:
                    zeros += 1
                case 1:
                    ones += 1
                case 2:
                    twos += 1
        for i in range(len(nums)):
            if i < zeros:
                nums[i] = 0
            elif i < zeros + ones:
                nums[i] = 1
            else:
                nums[i] = 2