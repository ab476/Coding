package ApnaCollege.StacksAndQueues;

import java.util.Stack;

public class MaxSumMinProduct {
    record ValuePosition(int index, int value) {}
    public int maxSumMinProduct(int[] nums) {
        long maxMinProd = 0;
        long mod = 1000_000_007L;
        
        var prefixSum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        var stack = new Stack<ValuePosition>();
        for(int i = 0; i < nums.length; i++) {
            if(stack.isEmpty() || stack.peek().value <= nums[i]) {
                stack.push(new ValuePosition(i, nums[i]));
            } else {
                int lastIndex = stack.peek().index;
                while(!stack.isEmpty() && stack.peek().value > nums[i]) {
                    var valuePos = stack.pop();
                    lastIndex = valuePos.index;
                    long currMaxMinProd = valuePos.value * (prefixSum[i] - prefixSum[valuePos.index]);
                    maxMinProd = Math.max(maxMinProd, currMaxMinProd);
                }
                stack.push(new ValuePosition(lastIndex, nums[i]));
            }
        }
        while(!stack.isEmpty()) {
            var valuePos = stack.pop();
            long currMaxMinProd = valuePos.value * (prefixSum[nums.length] - prefixSum[valuePos.index]);
            maxMinProd = Math.max(maxMinProd, currMaxMinProd);
        }
        return (int)(maxMinProd % mod);
    }
}
