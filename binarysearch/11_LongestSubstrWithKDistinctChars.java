import java.util.*;

class Solution {
    public int solve(int k, String s) {
        int lo = 0;
        int hi = s.length();

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(s, k, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo - 1;
    }

    boolean isPossible(String s, int k, int size) {
        // System.out.printf("s = %s, k = %d, size = %d\n", s, k, size);
        Map<Character, Integer> lastSeen = new HashMap<>();
        int chars = 0; // unique char count in current window
        
        for (int i = 0; i < s.length(); i++) {
            if (i >= size) {
                if (chars <= k) return true;
                
                char outgoing = s.charAt(i - size);

                if (lastSeen.get(outgoing) == i - size) {
                    lastSeen.remove(outgoing);
                    chars--;
                }
            }

            char ch = s.charAt(i);
            if (!lastSeen.containsKey(ch)) chars++;
            lastSeen.put(ch, i);
        }

        return chars <= k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println(s.solve(2, "abcba"));
        System.out.println(s.solve(3, "aaabc"));
        System.out.println(s.solve(2, "cbcbc"));
        System.out.println(s.solve(1, "cbcbc"));
    }
}
