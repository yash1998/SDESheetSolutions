package DynamicP.DPonStocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] prevBuy = new int[k+1], prevNotBuy = new int[k+1];
        for(int i=n-1; i>=0; i--) {
            int[] newBuy = new int[k+1], newNotBuy = new int[k+1];
            for(int j=0 ; j <= 1; j++) {
                for(int cap=1; cap<=k; cap++) {
                    if (j == 1) {
                        newBuy[cap] = Math.max(
                            -1 * prices[i] + prevNotBuy[cap],
                            0 + prevBuy[cap]
                        );
                    } else {
                        newNotBuy[cap] = Math.max(
                            prices[i] + prevBuy[cap-1],
                            0 + prevNotBuy[cap]
                        );
                    }
                }
            }
            prevBuy = newBuy;
            prevNotBuy = newNotBuy;
        } 

        return prevBuy[k];
    }
}
