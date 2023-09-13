package DynamicP.DPonStocks;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BuySellStockCooldown {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp) Arrays.fill(row, -1);

        return solve(dp, prices, 0, n, 1, 1);
        // return solve1(prices);
    }

    public int solve(int[][] dp, int[] prices, int i, int n, int canBuy, int coolDown) {
        if (i >= n) return 0;

        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        if (canBuy == 1) {      // canBuy == 0 ? false : true
            dp[i][canBuy] = Math.max(
                -1 * prices[i] + solve(dp, prices, i+1, n, 0, coolDown),
                0 + solve(dp, prices, i+1, n, 1, coolDown)
            );
        } else {
            dp[i][canBuy] = Math.max(
                prices[i] + solve(dp, prices, i+1+coolDown, n, 1, coolDown),
                0 + solve(dp, prices, i+1, n, 0, coolDown)
            );
        }
        return dp[i][canBuy];
    }

    public int solve1(int[] prices) {
        int n = prices.length, coolDown = 1;
        int[][] dp = new int[n+1+coolDown][2];

        for (int i=n-1; i>=0; i--) {
            for(int j= 0; j<=1; j++) {
                if (j == 1) {
                    dp[i][j] = Math.max(
                        -1 * prices[i] + dp[i+1][0],
                        0 + dp[i+1][1]
                    );
                } else {
                    dp[i][j] = Math.max(
                        prices[i] + dp[i+1+coolDown][1],
                        0 + dp[i+1][0]
                    );
                }
            }
        }
        return dp[0][1];
    }
}
