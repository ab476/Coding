class Solution(object):
    def threeSum(self, nums: list[int]) -> list[list[int]]: 
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        for i, n in enumerate(nums):
            if i >  0 and n == nums[i -1]:
                continue
            left, right = i + 1, len(nums) - 1
            while left < right:
                current_sum = n + nums[left] + nums[right]
                if current_sum == 0:
                    result.append([n, nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while right > left and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif current_sum < 0:
                    left += 1
                else:
                    right -= 1
        return result