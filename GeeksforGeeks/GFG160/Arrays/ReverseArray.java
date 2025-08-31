

public class ReverseArray {
    public void reverseArray(int arr[]) {
        // code here
        int mid = (arr.length / 2) - 1;
        int last = arr.length - 1;
        for (int i = 0; i <= mid; i++) {
            int temp = arr[last - i];
            arr[last - i] = arr[i];
            arr[i] = temp;
        }
    }
}
