/**
 * Binary Special String
 * The number of 0's is equal to the number of 1's.
 * Every prefix of the binary string has at least as many 1's as 0's.
 * 
 * "1100|10|111000" -> "1100|111000|10" -> "111000|1100|10"
 */

import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        return makeLargestSpecial(s, 0, s.length() - 1);
    }

    private String makeLargestSpecial(String s, int l, int r) {
        int balance = 0;
        List<String> specialStrings = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '0') balance--;
            else balance++;
            if (balance == 0) {
                specialStrings.add("1" + makeLargestSpecial(s, l + 1, i - 1) + "0");
                l = i + 1;
            }
        }
        Collections.sort(specialStrings, Comparator.reverseOrder());
        return String.join("", specialStrings);
    }
}
