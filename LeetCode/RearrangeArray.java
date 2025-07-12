package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            boolean positive = i % 2 == 0;
            if(positive){
                while (nums[pos] < 0) {
                    pos++;
                }
                arr[i] = nums[pos++];
            } else {
                while (nums[neg] > 0) {
                    neg++;
                }
                arr[i] = nums[neg++];
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var arr = Arrays.stream(sc.nextLine().replaceAll("[\\[\\]]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(new RearrangeArray().rearrangeArray(arr)).replaceAll(" ", ""));
        sc.close();
    }
}
