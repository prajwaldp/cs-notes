import java.util.*;

class Solution {
  public int countArrangement(int n) {
    int[][] cache = new int[n + 1][(int)Math.pow(2, n) + 1];
    for (int[] used: cache) {
      Arrays.fill(used, -1);
    }

    return backtrack(1, 0, n, cache);
  }

  private int backtrack(int pos, int used, int n, int[][] cache) {
    if (pos == n + 1) {
      return 1;
    }

    if (cache[pos][used] != -1) {
      return cache[pos][used];
    }

    int ways = 0;
    for (int i = 1; i <= n; i++) {
      if ((used & (1 << (i - 1))) == 0 && (i % pos == 0 || pos % i == 0)) {
        ways += backtrack(pos + 1, used | 1 << (i - 1), n, cache);
      }
    }

    return cache[pos][used] = ways;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countArrangement(2));
    System.out.println(s.countArrangement(6));
    System.out.println(s.countArrangement(15));
  }
}