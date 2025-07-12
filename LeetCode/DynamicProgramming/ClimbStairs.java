package LeetCode.DynamicProgramming;

import java.util.HashMap;

public class ClimbStairs {
    public int climbStairs(int n, HashMap<Integer, Integer> memo) {
        if (n <= 1) return 1; // Base case: 1 way to climb 0 or 1 step
        if (memo.containsKey(n)) return memo.get(n); // Return cached result

        // Recursive case: sum of ways to climb n-1 and n-2 steps
        int ways = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo.put(n, ways); // Cache the result
        return ways;
    }
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>()); // Initialize memoization
    }
}
