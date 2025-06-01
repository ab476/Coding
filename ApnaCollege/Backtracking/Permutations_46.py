from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res : List[List[int]] = []
        visited = [False] * len(nums)
        def backtrack(ans: list[int]):
            if len(ans) == len(nums):
                res.append(ans[:])
                return
            for i in range(len(nums)):
                if not visited[i]:
                    ans.append(nums[i])
                    visited[i] = True
                    backtrack(ans)
                    visited[i] = False
                    ans.pop()
        backtrack([])
        return res
# Example usage:    
sol = Solution()
print(sol.permute([1, 2, 3]))
