package DynamicP.DPonStocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
public class BuySellStockTxnFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int prevBuy = 0, prevNotBuy = 0;
        for (int i=n-1; i>=0; i--) {
            int newBuy = 0, newNotBuy = 0;
            for(int j= 0; j<=1; j++) {
                if (j == 1) {
                    newBuy = Math.max(-1 * prices[i] + prevNotBuy, 0 + prevBuy);
                } else {
                    newNotBuy = Math.max(prices[i] - fee + prevBuy, 0 + prevNotBuy);
                }
            }
            prevBuy = newBuy;
            prevNotBuy = newNotBuy;
        }
        return prevBuy;
    }
}
