class Solution {
  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }

    int odds = 0;

    for (int count: freq.values()) {
      if (count % 2 == 1 && ++odds > 1) {
        return false;
      }
    }

    return true;
  }
}