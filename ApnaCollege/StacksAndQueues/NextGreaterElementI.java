package ApnaCollege.StacksAndQueues;

import java.util.Hashtable;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        int i = 0;
        for(int num : nums2) {
            map.put(num, i++);
        }

        int[] res = new int[nums1.length];
        i = 0;
        for(int num : nums1) {
            int index = map.get(num);
            int nextGreater = - 1;
            while(index < nums2.length) {
                if(nums2[index] > num) {
                    nextGreater = nums2[index];
                    break;
                }
                index++;
            }
            res[i++] = nextGreater;
        }
        return res;
    }
}
