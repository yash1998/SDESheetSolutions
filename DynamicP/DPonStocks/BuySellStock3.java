package DynamicP.DPonStocks;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][][] dp = new int[n][2][3];
        for(int[][] row: dp) {
            for(int[] nest: row) Arrays.fill(nest, -1);
        }

        return solve(dp, prices, 0, n, 1, 2);
        // return solve1(prices);
        // return solve2(prices);
    }

    public int solve(int[][][] dp, int[] prices, int i, int n, int canBuy, int cap) {
        if (i == n || cap == 0) return 0;

        if (dp[i][canBuy][cap] != -1) return dp[i][canBuy][cap];

        if (canBuy == 1) {      // canBuy == 0 ? false : true
            dp[i][canBuy][cap] = Math.max(
                -1 * prices[i] + solve(dp, prices, i+1, n, 0, cap),
                0 + solve(dp, prices, i+1, n, 1, cap)
            );
        } else {
            dp[i][canBuy][cap] = Math.max(
                prices[i] + solve(dp, prices, i+1, n, 1, cap-1),
                0 + solve(dp, prices, i+1, n, 0, cap)
            );
        }
        return dp[i][canBuy][cap];
    }

    public int solve1(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<=1; j++) {
                dp[i][j][0] = 0;
            }
        }
        for(int i=0; i<=1; i++) {
            for(int j=0; j<=2; j++) {
                dp[n][i][j] = 0;
            }
        }
        for(int i=n-1; i>=0; i--) {
            for(int j=0 ; j <= 1; j++) {
                for(int k=1; k<=2; k++) {
                    if (j == 1) {
                        dp[i][j][k] = Math.max(
                            -1 * prices[i] + dp[i+1][0][k],
                            0 + dp[i+1][1][k]
                        );
                    } else {
                        dp[i][j][k] = Math.max(
                            prices[i] + dp[i+1][1][k-1],
                            0 + dp[i+1][0][k]
                        );
                    }
                }
            }
        } 

        return dp[0][1][2];
    }

    public int solve2(int[] prices) {
        int n = prices.length;
        int[] prevBuy = new int[3], prevNotBuy = new int[3];
        for(int i=n-1; i>=0; i--) {
            int[] newBuy = new int[3], newNotBuy = new int[3];
            for(int j=0 ; j <= 1; j++) {
                for(int k=1; k<=2; k++) {
                    if (j == 1) {
                        newBuy[k] = Math.max(
                            -1 * prices[i] + prevNotBuy[k],
                            0 + prevBuy[k]
                        );
                    } else {
                        newNotBuy[k] = Math.max(
                            prices[i] + prevBuy[k-1],
                            0 + prevNotBuy[k]
                        );
                    }
                }
            }
            prevBuy = newBuy;
            prevNotBuy = newNotBuy;
        } 

        return prevBuy[2];
    }
}
