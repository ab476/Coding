
def numTilings(n: int) -> int:

    def f(n: int, t1: bool, t2: bool, memo: dict) -> int:
        if (n, t1 and t2) in memo:
            return memo[(n, t1 and t2)]
        if n == 1 or n == 0:
            return 1
        
        t3, t4 = n > 1, n > 1
        ways = 0
        if(t1 and t2):
            ways += f(n - 1, t3, t4, memo)
        if(t1 and t2 and t3 and t4):
            ways += f(n - 2, n-2 > 0, n-2 > 0, memo)
        if(t1 and t2 and t3):
            ways += f(n - 1, False, True, memo)
        if(t1 and t2 and t4):
            ways += f(n - 1, True, False, memo)
        if(t1 is False and t2 and t4):
            ways += f(n - 1, True, False, memo) * 2
        if(t1 is False and t2 and t3 and t4):
            ways += f(n - 2, n - 2 > 0, n - 2 > 0, memo) * 2

        memo[(n, t1 and t2)] = ways % (10**9 + 7)
        return memo[(n, t1 and t2)]
    
    return f(n, n > 0, n > 0, {})


numTilings(3)