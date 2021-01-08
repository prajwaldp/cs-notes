class Solution {
  public String shortestCommonSupersequence(String s1, String s2) {
    String lcs = buildLCS(s1, s2);
    int n1 = s1.length();
    int n2 = s2.length();
    int n3 = lcs.length();

    int i = 0;
    int j = 0;
    int k = 0;

    StringBuilder sb = new StringBuilder();
    while (i < n1 || j < n2) {
      while (i < n1 && (k == n3 || s1.charAt(i) != lcs.charAt(k))) {
        sb.append(s1.charAt(i));
        i++;
      }
      while (j < n2 && (k == n3 || s2.charAt(j) != lcs.charAt(k))) {
        sb.append(s2.charAt(j));
        j++;
      }
      while (k < n3 && i < n1 && s1.charAt(i) == lcs.charAt(k) &&
          j < n2 && s2.charAt(j) == lcs.charAt(k)) {
        sb.append(s1.charAt(i));
        i++;
        j++;
        k++;
      }
    }

    return sb.toString();
  }

  private String buildLCS(String s1, String s2) {
    int n1 = s1.length();
    int n2 = s2.length();
    int[][] dp = new int[n1 + 1][n2 + 1];

    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    int i = n1;
    int j = n2;
    StringBuilder sb = new StringBuilder();
    while (i != 0 && j != 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        sb.insert(0, s1.charAt(i - 1));
        i--;
        j--;
      } else {
        if (dp[i - 1][j] > dp[i][j - 1]) {
          i--;
        } else {
          j--;
        }
      }
    }

    return sb.toString();
  }
}