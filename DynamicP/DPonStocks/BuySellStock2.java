package DynamicP.DPonStocks;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp) Arrays.fill(row, -1);

        return solve(dp, prices, 0, n, 1);
        // return solve1(prices);
        // return solve2(prices);
    }

    public int solve(int[][] dp, int[] prices, int i, int n, int canBuy) {
        if (i == n) return 0;

        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        if (canBuy == 1) {      // canBuy == 0 ? false : true
            dp[i][canBuy] = Math.max(
                -1 * prices[i] + solve(dp, prices, i+1, n, 0),
                0 + solve(dp, prices, i+1, n, 1)
            );
        } else {
            dp[i][canBuy] = Math.max(
                prices[i] + solve(dp, prices, i+1, n, 1),
                0 + solve(dp, prices, i+1, n, 0)
            );
        }
        return dp[i][canBuy];
    }

    // Tabulation method - bottom up
    public int solve1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int i=n-1; i>=0; i--) {
            for(int j= 0; j<=1; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(
                        prices[i] + dp[i+1][1],
                        0 + dp[i+1][0]
                    );
                } else {
                    dp[i][j] = Math.max(
                        -1 * prices[i] + dp[i+1][0],
                        0 + dp[i+1][1]
                    );
                }
            }
        }
        return dp[0][1];
    }

    // space optimization
    public int solve2(int[] prices) {
        int n = prices.length;
        int prevBuy = 0, prevNotBuy = 0;
        for (int i=n-1; i>=0; i--) {
            int newBuy = 0, newNotBuy = 0;
            for(int j= 0; j<=1; j++) {
                if (j == 1) {
                    newBuy = Math.max(-1 * prices[i] + prevNotBuy, 0 + prevBuy);
                } else {
                    newNotBuy = Math.max(prices[i] + prevBuy, 0 + prevNotBuy);
                }
            }
            prevBuy = newBuy;
            prevNotBuy = newNotBuy;
        }
        return prevBuy;
    }
}
