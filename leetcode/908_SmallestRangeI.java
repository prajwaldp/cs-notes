import java.util.*;

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int a: A) {
            mx = Math.max(mx, a);
            mn = Math.min(mn, a);
        }
        return Math.max(0, mx - mn - 2 * K);
    }
}
