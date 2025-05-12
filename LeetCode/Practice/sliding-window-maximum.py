from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        dq = deque(maxlen=k)
        res = []
        for i in range(len(nums)):
            if(dq and dq[0] < i - k + 1):
                dq.popleft()
            while dq and nums[dq[-1]] < nums[i]:
                dq.pop()
            dq.append(i)

            if i >= k - 1:
                res.append(nums[dq[0]])
            print(f"index: {i}, deque: {list(dq)}, nums: {nums}, res: {res}")
        return res
            
# Test the function
if __name__ == "__main__":
    solution = Solution()
    nums = [1,3,-1,-3,5,3,6,7]
    k = 3
    print(solution.maxSlidingWindow(nums, k))  # Output: [3,3,5,5,6,7]
                