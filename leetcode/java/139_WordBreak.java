class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    Set<String> wordSet = new HashSet<>();
    wordSet.addAll(wordDict);
    wordSet.add("");


    for (int i = 1; i <= n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[n];
  }
}