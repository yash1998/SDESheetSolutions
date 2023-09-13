package DynamicP;

public class LCSubstring {
    public static int lcSubstr(String str1, String str2) {
		int n = str1.length(), m = str2.length();
        int[][] tab = new int[n+1][m+1];
		int maxLength = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    tab[i][j] = 1 + tab[i-1][j-1];
					maxLength = Math.max(maxLength, tab[i][j]);
                } else {
                    tab[i][j] = 0;
                }
            }
        }

        return maxLength;
	}
}
