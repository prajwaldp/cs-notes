class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>();
    wordSet.addAll(wordDict);
    wordSet.add("");

    if (!isBreakable(s, wordSet)) {
      return new ArrayList<>();
    }

    List<String> curr = new ArrayList<>();
    List<String> result = new ArrayList<>();
    dfs(s, 0, wordSet, curr, result);

    return result;
  }

  private void dfs(String s, int pos, Set<String> wordSet, List<String> curr,
                   List<String> result) {

    int n = s.length();
    if (pos == n) {
      String splitString = curr.stream().collect(Collectors.joining(" "));
      result.add(splitString);
      return;
    }

    for (int i = pos + 1; i <= n; i++) {
      String sub = s.substring(pos, i);
      if (wordSet.contains(sub)) {
        curr.add(sub);
        dfs(s, i, wordSet, curr, result);
        curr.remove(curr.size() - 1);
      }
    }
  }

  private boolean isBreakable(String s, Set<String> wordSet) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

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