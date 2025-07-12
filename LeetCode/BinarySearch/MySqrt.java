package LeetCode.BinarySearch;

public class MySqrt {
    public int mySqrt(int x) {
        int left = 0;        
        int right = x;       

        while (left < right) { 
            int mid = (left + right + 1) >>> 1; 

            if (mid <= x / mid) { 
                left = mid;        
            } else {
                right = mid - 1;   
            }
        }
        return left; 
    }
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(8)); // Output: 2
        // System.out.println(mySqrt.mySqrt(16)); // Output: 4
        // System.out.println(mySqrt.mySqrt(25)); // Output: 5
        // System.out.println(mySqrt.mySqrt(0)); // Output: 0
        // System.out.println(mySqrt.mySqrt(1)); // Output: 1
    }
}
