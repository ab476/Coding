

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int pos = n - 2;
        for (int i = pos; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
            pos--;
        }
        int end = n - 1;
        if (pos >= 0) {
            while (arr[pos] >= arr[end]) {
                end--;
            }
            swap(arr, pos, end);
        }
        end = n - 1;
        for (int st = pos + 1; st < end; st++, end--) {
            swap(arr, st, end);
        }

    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        var scanner = new Scanner(System.in);
        // read a line, split by space, convert to int[]
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // example: call nextPermutation
        np.nextPermutation(arr);

        // print result
        System.out.println(Arrays.toString(arr));

        scanner.close();
    }
}
