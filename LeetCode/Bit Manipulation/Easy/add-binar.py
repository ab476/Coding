class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry = 0
        res = ''

        for i in range(max(len(a), len(b))):
            digit_a = int(a[-(i + 1)]) if i < len(a) else 0
            digit_b = int(b[-(i + 1)]) if i < len(b) else 0

            total = digit_a + digit_b + carry
            carry = total // 2
            res = str(total % 2) + res
        
        if carry:
            res = '1' + res
        return res