class Solution:
    def maxScore(self, s: str) -> int:
        prefix_zeros = [0] * (len(s) + 1)
        prefix_ones = [0] * (len(s) + 1)
        max_score = 0
        for i, ch in enumerate(s):
            prefix_zeros[i + 1] = prefix_zeros[i] + (1 if ch == '0' else 0)
            prefix_ones[i + 1] = prefix_ones[i] + (1 if ch == '1' else 0)
            

        for i in range(1, len(s) - 1):
            score = prefix_zeros[i + 1] + (prefix_ones[-1] - prefix_ones[i + 1])
            max_score = max(max_score, score)

        return max_score

if __name__ == "__main__":
    solution = Solution()
    print(solution.maxScore("011101"))