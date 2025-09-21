import java.util.Scanner;

public class MaximumProfit {
    public int maximumProfit(int prices[]) {
        int profit = 0;
        for(int i =1; i < prices.length; i ++) {
            int diff = prices[i] - prices[i - 1];
            if(diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var arr = scanner.nextLine().split(" ");
        var prices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        var maximumProfit = new MaximumProfit();
        System.out.println(maximumProfit.maximumProfit(prices));
        scanner.close();
    }
}
