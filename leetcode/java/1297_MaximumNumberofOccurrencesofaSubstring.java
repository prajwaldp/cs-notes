import java.util.*;

class Solution {
  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    final int MOD = (int)1e9 + 7;
    final int BASE = 26;

    int ans = 0;

    int hash = 0;
    int pow = 1;

    Map<Integer, Integer> occurence = new HashMap<>();
    Map<Character, Integer> count = new HashMap<>();

    for (int i = 0; i < minSize; i++) {
      hash = (hash * BASE) % MOD + s.charAt(i) - 'a';
      pow = (pow * BASE) % MOD;
      count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
    }

    if (count.size() <= maxLetters) {
      occurence.put(hash, occurence.getOrDefault(hash, 0) + 1);
      ans = Math.max(ans, occurence.get(hash));
    }

    pow /= BASE;

    for (int i = minSize; i < s.length(); i++) {
      char entering = s.charAt(i);
      char leaving = s.charAt(i - minSize);

      hash -= (leaving - 'a') * pow;
      hash = (hash * BASE) % MOD + entering - 'a';

      count.put(leaving, count.get(leaving) - 1);
      if (count.get(leaving) == 0) {
        count.remove(leaving);
      }

      count.put(entering, count.getOrDefault(entering, 0) + 1);

      if (count.size() <= maxLetters) {
        occurence.put(hash, occurence.getOrDefault(hash, 0) + 1);
        ans = Math.max(ans, occurence.get(hash));
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    var s = new Solution();
    int ans = s.maxFreq("aababcaab", 2, 3, 4);
    System.out.println(ans);
  }
}