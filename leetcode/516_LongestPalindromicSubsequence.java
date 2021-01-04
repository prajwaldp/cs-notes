class Solution {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] cache = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          cache[i][j] = 1;
        } else {
          cache[i][j] = -1;
        }
      }
    }
    return lps(s, 0, n - 1, cache);
  }

  private int lps(String s, int lo, int hi, int[][] cache) {
    if (lo > hi) {
      return 0;
    }

    if (cache[lo][hi] != -1) {
      return cache[lo][hi];
    }

    if (s.charAt(lo) == s.charAt(hi)) {
      return cache[lo][hi] = 2 + lps(s, lo + 1, hi - 1, cache);
    }

    return cache[lo][hi] = Math.max(lps(s, lo + 1, hi, cache),
        lps(s, lo, hi - 1, cache));
  }
}

class SolutionAlt {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(n - i) == s.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][n];
  }
}