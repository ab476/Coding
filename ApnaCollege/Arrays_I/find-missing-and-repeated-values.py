from typing import List


class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        counter = [0 for i in range(len(grid) * len(grid))]
    
        for list in grid:
            for i in list:
                counter[i-1] += 1

        repeated = None
        missing = None
        for i in range(len(counter)):
            if(repeated and missing):
                break
            num = counter[i]
            if num == 0:
                missing = i + 1
            elif num > 1:
                repeated = i + 1
            
        return [repeated, missing]
    
if __name__ == "__main__":
    
    print(Solution().findMissingAndRepeatedValues([[1,3],[2,2]]))  # Output: [4, 2]