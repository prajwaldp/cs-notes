import java.util.*;

class Solution {
    public int solve(String s) {
        int lo = 1, hi = s.length();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (containsDuplicate(s, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo - 1;
    }

    /**
     * Returns true if s contains a duplicate substring of size n
     */
    public boolean containsDuplicate(String s, int n) {
        final long BASE = 26;
        final long MOD = (int)1e9 + 7;
        
        Map<Long, Integer> hashes = new HashMap<>();

        long hash = 0;
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a' + 1;
            hash = (hash * BASE) % MOD + ch;
        }

        long pow = 1;
        for (int i = 0; i < n - 1; i++) {
            pow = (pow * BASE) % MOD;
        }
        hashes.put(hash, 0);
        // System.out.printf("%s => %d\n", s.substring(0, n), hash);
        
        for (int i = n; i < s.length(); i++) {
            int leavingCh = s.charAt(i - n) - 'a' + 1;
            int enteringCh = s.charAt(i) - 'a' + 1;
            hash -= (pow * leavingCh) % MOD;
            hash = (hash * BASE) % MOD + enteringCh;

            // System.out.printf("%s => %ld\n", s.substring(i - n + 1, i + 1), hash);
            if (hashes.containsKey(hash)) {
                int prev = hashes.get(hash);
                if (s.substring(prev, prev + n).compareTo(s.substring(i - n + 1, i + 1)) == 0) {
                    System.out.println(s.substring(prev, prev + n));
                    System.out.println(s.substring(i - n + 1, i + 1));
                    return true;
                }
            }
            hashes.put(hash, i - n + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate("zzzhellozzzhello", 7));
        System.out.println(s.containsDuplicate("zzzhellozzzhello", 8));
        String[] inputs = {"abcdeabcd", "aaaaa", "a", "", "aa", "aac", "zzzzzzhellozzzhellozzz"};
        //String[] inputs = {"zzzzzzhellozzzhellozzz"};
        for (var ip: inputs) {
            System.out.printf("%s => %d\n", ip, s.solve(ip));
        }
    }
}
