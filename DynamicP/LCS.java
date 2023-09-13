package DynamicP;

public class LCS {

    // Length of LCS
    public int lcs(String text1, String text2) {
        int n = text1.length(), m= text2.length();
        int[][] dp= new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    // Print LCS
    public static String printLCS(int n, int m, String s1, String s2){
        int[][] dp= new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while(i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
