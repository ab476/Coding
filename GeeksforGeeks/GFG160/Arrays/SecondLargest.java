package GeeksforGeeks.GFG160.Arrays;

public class SecondLargest {
    public int getSecondLargest(int[] arr) {
        // code here
        int max = -1;
        int second = -1;
        
        for(int num : arr) {
            if(num > max) {
                if(max > second) {
                    second = max;
                }
                max = num;
            } else if(num < max && num > second) {
                second = num;
            }
        }
        return second;
    }
}
