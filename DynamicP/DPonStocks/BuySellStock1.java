package DynamicP.DPonStocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuySellStock1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minTillNow = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] < minTillNow) {
                minTillNow = prices[i];
            }
            int currProfit = prices[i] - minTillNow;
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }
        return maxProfit;
    }
}
