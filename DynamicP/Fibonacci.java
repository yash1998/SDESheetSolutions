package DynamicP;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n < 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        Arrays.fill(dp, -1);

        return fibRecursive(n);
        // return fibMemoization(n, dp);
        // return fibTabulation(n, dp);
    }

    // DP Bottom up tabulation code
    public static int fibTabulation(int n, int[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // DP Top-down memoization code
    public static int fibMemoization(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = fibMemoization(n - 1, dp) + fibMemoization(n - 2, dp);
        return dp[n];
    }

    // Normal recursive code
    public static int fibRecursive(int n) {
        if (n <= 1)
            return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
}
