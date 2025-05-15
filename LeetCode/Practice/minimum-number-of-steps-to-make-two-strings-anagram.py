class Solution:
    def minSteps(self, s: str, t: str) -> int:
        n = len(s)
        count = [0] * 26
        for i in range(n):
            count[ord(s[i]) - ord('a')] += 1
            count[ord(t[i]) - ord('a')] -= 1

        ans = 0
        for i in range(26):
            if count[i] > 0:
                ans += count[i]
        return ans