package ApnaCollege.Arrays_II;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1}; // return an empty array if no solution is found
    }
}
