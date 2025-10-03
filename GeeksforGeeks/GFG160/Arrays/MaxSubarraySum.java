public class MaxSubarraySum {
    int maxSubarraySum(int[] arr) {
        // Code here
        int maxSum = Integer.MIN_VALUE;
        int sum = maxSum;
        
        for(int n : arr) {
            if(sum < 0) {
                sum = n;
            } else {
                sum += n;
            }
            
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        
        return maxSum;
    }
}
