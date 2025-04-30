from typing import List


class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        rows_MinMax = [(n, -1) for _ in range(n+1)]
        cols_MinMax = [(n, -1) for _ in range(n+1)]
        covered = 0
        for [x, y] in buildings:
            min_x, max_x = rows_MinMax[y]
            min_y, max_y = cols_MinMax[x]
            
            rows_MinMax[y] = (min(min_x, x), max(max_x, x))
            cols_MinMax[x] = (min(min_y, y), max(max_y, y))

        for [x, y] in buildings:
            min_x, max_x = rows_MinMax[y]
            min_y, max_y = cols_MinMax[x]
            if min_x < x and max_x > x and min_y < y and max_y > y:
                covered += 1
        return covered

if __name__ == "__main__":
    res = Solution().countCoveredBuildings(5, [[1,3],[3,2],[3,3],[3,5],[5,3]])
    print(res)  # Output: 5