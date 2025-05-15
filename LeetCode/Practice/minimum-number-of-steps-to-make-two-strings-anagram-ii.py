class Solution:
    def minSteps(self, s: str, t: str) -> int:
        count = [0] * 26
        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1
        for i in range(len(t)):
            count[ord(t[i]) - ord('a')] -= 1
        return sum(abs(x) for x in count)