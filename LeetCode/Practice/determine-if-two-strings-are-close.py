class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        count1 = [0] * 26
        count2 = [0] * 26
        for c in word1:
            count1[ord(c) - ord('a')] += 1
        for c in word2:
            count2[ord(c) - ord('a')] += 1
        return set(word1) == set(word2) and sorted(count1) == sorted(count2)
    
if __name__ == "__main__":
    s = Solution()
    print(s.closeStrings("abc", "bca"))  # True
    print(s.closeStrings("a", "aa"))  # False
    print(s.closeStrings("cabbba", "abbccc"))  # True
    print(s.closeStrings("cabbba", "aabbss"))  # False