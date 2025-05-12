from typing import List


class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        count = [0] * 10
        for digit in digits:
            count[digit] += 1
        result = []
        for i in range(100, 1000):
            if i % 2 == 0:
                temp = [0] * 10
                valid = True
                for digit in str(i):
                    temp[int(digit)] += 1
                    if( temp[int(digit)] > count[int(digit)]):
                        valid = False
                        break
                if valid:
                    result.append(i)

        return result