package GeeksforGeeks.GFG160.Arrays;

public class PushZerosToEnd {
    void pushZerosToEnd(int[] arr) {
        // code here
        int st = 0, end = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                arr[st++] = arr[i];
                end = i;
            } 
            
        }
        for(int i = st; i <= end; i++) {
            arr[i] = 0;
        }
    }
}
