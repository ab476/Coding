package ApnaCollege.Arrays_II;

class SortColors {
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0;
        for (int n: nums){
            switch (n) {
                case 0 -> zeros++;
                case 1 -> ones++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i < zeros) {
                nums[i] = 0;
            } else if (i < zeros + ones) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}