class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] cache = new int[m][n];
    for (int[] row: cache) {
      Arrays.fill(row, -1);
    }
    return lcs(text1, text2, 0, 0, cache);
  }

  private int lcs(String text1, String text2, int i, int j, int[][] cache) {
    if (i == text1.length() || j == text2.length()) {
      return 0;
    }

    if (cache[i][j] != -1) {
      return cache[i][j];
    }

    if (text1.charAt(i) == text2.charAt(j)) {
      return cache[i][j] = 1 + lcs(text1, text2, i + 1, j + 1, cache);
    }

    return cache[i][j] = Math.max(lcs(text1, text2, i + 1, j, cache),
        lcs(text1, text2, i, j + 1, cache));
  }
}

class SolutionAlt {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }
}
