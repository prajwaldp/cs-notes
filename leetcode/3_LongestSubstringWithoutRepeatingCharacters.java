class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastOccurenceAt = new HashMap<>();
        int longestLength = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (lastOccurenceAt.containsKey(ch) && lastOccurenceAt.get(ch) >= i) {
                i = lastOccurenceAt.get(ch) + 1;
            }
            lastOccurenceAt.put(ch, j);
            longestLength = Math.max(longestLength, j - i + 1);
        }
        return longestLength;
    }
}