from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rowNo = len(matrix) - 1
        colNo = 0
        while rowNo >= 0 and colNo < len(matrix[0]):
            if matrix[rowNo][colNo] == target:
                return True
            elif matrix[rowNo][colNo] >  target:
                rowNo -= 1
            else:
                colNo += 1
        return False
