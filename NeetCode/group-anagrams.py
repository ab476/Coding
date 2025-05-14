from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mapList: dict[str, list[str]] = {}

        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            key = tuple(count)
            if key in mapList:
                mapList[key].append(s)
            else:
                mapList[key] = [s]
        return list(mapList.values())
# Test the function
if __name__ == "__main__":
    solution = Solution()
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(solution.groupAnagrams(strs))  # Output: [["bat"],["nat","tan"],["ate","eat","tea"]]