package ApnaCollege.Recursion_II;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    public static int search(int[] nums, int target, int start, int end) {
        System.out.println("start: " + start + ", end: " + end + ", target: " + target);
        printArr(nums, start, end);
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[start] <= nums[mid]) {
            if(nums[start] <= target && target <= nums[mid]) {
                return search(nums, target, start, mid - 1);
            } else {
                return search(nums, target, mid + 1, end);
            }
        } else {
            if(nums[mid] <= target && target <= nums[end]) {
                return search(nums, target, mid + 1, end);
            } else {
                return search(nums, target, start, mid - 1);
            }
        }
    }
    private static void printArr(int[] arr) {
        printArr(arr, 0, arr.length - 1);
    }
    private static void printArr(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        var list = new int[] { 4,5,6,7,0,1,2 };
        int target = search(list, 0);
        System.out.println("Target found at index: " + target);
    }
}
