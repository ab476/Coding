import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        var minHeap = new PriorityQueue<Integer>();
        for (int num : nums) {
            if(minHeap.size() < k || num > minHeap.peek()){
                minHeap.add(num);
            }
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        var sc  = new Scanner(System.in);
        var arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        var k = sc.nextInt();
        System.out.println(new FindKthLargest().findKthLargest(arr, k));
        sc.close();
    }
}