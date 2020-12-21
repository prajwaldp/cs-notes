/*
leet2code3

l e e t 2 c  o  d  e  3
1 2 3 4 8 9 10 11 12 36

20
12 + x = 20, x = 8

30
12 + x = 30, x = 18
12 + y = 18, y = 6
*/

import java.util.*;

class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long[] len = new long[n];
        len[0] = 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            len[i] = Character.isDigit(c) ? len[i - 1] * (c - '0') : len[i - 1] + 1;
        }
        int i = n - 1;
        while (len[i] > k) {
            i--;
            if (len[i] < k) {
                // while (k - len[i] > len[i]) {
                //     k -= len[i];
                // }
                // k -= len[i];
                
                k = (int)(k % len[i]);
                if (k == 0) {
                    break;
                }
            }
        }

        while (Character.isDigit(s.charAt(i))) i--;
        
        return s.substring(i, i + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ip1 = {"leet2code3", "leet2code3"};
        int[] ip2 = {20, 30};
        for (int i = 0; i < 2; i++) {
            System.out.printf("%s, %d => %s\n", ip1[i], ip2[i], s.decodeAtIndex(ip1[i], ip2[i]));
        }
    }
}
