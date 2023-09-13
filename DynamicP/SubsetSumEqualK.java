package DynamicP;

public class SubsetSumEqualK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Recursive
        // return solve0(n, k, arr);

        // Memoization - Top/down
        // int[][] dp = new int[n+1][k+1];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // solve1(n, k, arr, dp);
        // return dp[n][k] == 0 ? false : true;

        // Tabulation - Bottom/up
        return solve2(n, k, arr);
    }

    // Recursive
    public static boolean solve0(int n, int k, int[] arr) {
        if (k == 0)
            return true;
        if (n == 0)
            return false;

        boolean res = solve0(n - 1, k, arr);
        if (arr[n - 1] <= k) {
            res = res || solve0(n - 1, k - arr[n - 1], arr);
        }
        return res;
    }

    // Memoization - Top/down
    public static boolean solve1(int n, int k, int[] arr, int[][] dp) {
        if (k == 0)
            return true;
        if (n == 0)
            return false;

        if (dp[n][k] != -1)
            return dp[n][k] == 0 ? false : true;

        boolean res = solve1(n - 1, k, arr, dp);
        if (arr[n - 1] <= k) {
            res = res || solve1(n - 1, k - arr[n - 1], arr, dp);
        }
        dp[n][k] = res ? 1 : 0;

        return res;
    }

    // Tabulation - Bottom/up
    public static boolean solve2(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= k; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean res = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    res = res || dp[i - 1][j - arr[i - 1]];
                }
                dp[i][j] = res;
            }
        }
        return dp[n][k];
    }

    // *Optional - Space optimization
    public static boolean solve3(int n, int k, int arr[]) {
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        for (int i = 1; i <= k; i++)
            prev[i] = false;

        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int j = 1; j <= k; j++) {
                boolean res = prev[j];
                if (arr[i - 1] <= j) {
                    res = res || prev[j - arr[i - 1]];
                }
                curr[j] = res;
            }
            prev = curr;
        }
        return prev[k];
    }
}
