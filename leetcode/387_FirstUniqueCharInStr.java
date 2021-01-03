class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (counts.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}