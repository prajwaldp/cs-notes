// dp(i, j, k) where i is index into s1, j is index into s2, and k is index into s3
// if s3[k] == s1[i] => dp(i + 1, j, k + 1)
// if s3[k] == s2[j] => dp(i, j + 1, k + 1)

import java.util.*;

class Solution {
    private int[][][] cache;
    public boolean isInterleaveAlt(String s1, String s2, String s3) {
        cache = new int[100][100][200];
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        
        return dfs(s1, s2, s3, 0, 0, 0);
    }
    
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if (cache[i][j][k] == 0) return false;
        if (cache[i][j][k] == 1) return true;
        
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            cache[i][j][k] = 1;
            return true;
        } else if (k == s3.length()) {
            cache[i][j][k] = 0;
            return false;
        }
        
        boolean op1 = i != s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1);
        boolean op2 = j != s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1);
        
        if (op1 || op2) {
            cache[i][j][k] = 1;
            return true;
        }
        
        cache[i][j][k] = 0;
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        if (n + m != s3.length()) {
            return false;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 && dp[i][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = true;
                } else if (j == 0 && dp[i - 1][j] && s3.charAt(i - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) ||
                        (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
