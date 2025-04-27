from typing import Dict

class Solution:
    def F(self, n: int, dp: Dict[int, int]) -> int:
        if n <= 1:
            return n
        if n not in dp:
            dp[n] = self.F(n - 1, dp) + self.F(n - 2, dp)
        return dp[n]
    def fib(self, n: int) -> int:
       return self.F(n, {})