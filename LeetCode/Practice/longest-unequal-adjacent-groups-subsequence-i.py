from typing import List


class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        res: List[str] = []
        n = len(words)
        for i in range(n):
            if i == 0 or groups[i] != groups[i - 1]:
                res.append(words[i])
        return res