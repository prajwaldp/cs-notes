import java.util.*;

class Solution {
    public int solve(String msg) {
        int n = msg.length();
        int[] ways = new int[n + 1]; // ways[i] = number of ways to decode a string of size i
        ways[0] = 1;
        ways[1] = msg.charAt(0) >= '1' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            int d1 = msg.charAt(i - 2) - '0';
            int d2 = msg.charAt(i - 1) - '0';
            if (d2 >= 1) ways[i] = ways[i - 1];
            if ((d1 == 1 || d1 == 2) && d2 <= 6) ways[i] += ways[i - 2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solve("30"));
        System.out.println(s.solve("2626"));
        System.out.println(s.solve("1020"));
        System.out.println(s.solve("7258145"));
    }
}
