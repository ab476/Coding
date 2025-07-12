package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class SortColors {
    // red, white, and blue
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int num : nums){
            switch (num) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2: 
                    blue++;
                    break;
                default:
                    break;
            }
        }
        int[] arr = new int[nums.length];
        for(int i = red; i < arr.length; i++){
            if(white > 0){
                arr[i] = 1;
                white--;
            } else if(blue > 0){
                arr[i] = 2;
                blue --;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        new SortColors().sortColors(arr);
        sc.close();
    }
}
