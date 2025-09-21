public class MaximumProfitSingleOP {
    public int maximumProfit(int prices[]) {
        // Code here
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int price : prices) {
            if(price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
