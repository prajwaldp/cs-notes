class Solution {
  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    int n = s.length();
    int[][] freq = new int[n + 1][26];
    for (int i = 1; i <= n; i++) {
      freq[i] = Arrays.copyOf(freq[i - 1], 26);
      char ch = s.charAt(i - 1);
      freq[i][ch - 'a']++;
    }

    List<Boolean> ans = new ArrayList<>();

    for (int[] q: queries) {
      int sum = 0; 
      for (int i = 0; i < 26; i++) {
        sum += (freq[q[1] + 1][i] - freq[q[0]][i]) % 2;
      }
      ans.add(sum / 2 <= q[2]);
    }

    return ans;
  }
}

class SolutionAlt {
  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    int n = s.length();
    int[] odds = new int[n + 1];
    List<Boolean> ans = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      odds[i] = odds[i - 1] ^ (1 << (s.charAt(i - 1) - 'a'));
    }
    for (int[] q: queries) {
      ans.add(Integer.bitCount(odds[q[0]] ^ odds[q[1] + 1]) / 2 <= q[2]);
    }
    return ans;
  }
}