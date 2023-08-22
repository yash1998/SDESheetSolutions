package DynamicP;

import java.util.Arrays;

public class FrogJump1 {
    public static int frogJump(int n, int heights[]) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n-1, heights, dp);
    }

    public static int solve(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int left = 0, right = Integer.MAX_VALUE;
        left = solve(n-1, heights, dp)+Math.abs(heights[n]-heights[n-1]);
        if (n > 1) {
            right = solve(n-2, heights, dp)+Math.abs(heights[n]-heights[n-2]);
        }
        dp[n]=Math.min(left, right);
        return dp[n];
    }
}
