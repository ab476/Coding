package GeeksforGeeks.GFG160.Arrays;

public class RotateArr {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        int n = arr.length;
        d = d % n;
        rotate(arr, 0, d - 1);
        rotate(arr, d, n - 1);
        rotate(arr, 0, n - 1);
    }
    static void rotate(int arr[], int st, int end) {
        while(st < end) {
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
}
