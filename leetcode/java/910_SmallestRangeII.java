import java.util.*;

class Solution {
    public int smallestRangeII(int[] A, int k) {
        Arrays.sort(A);
        int n = A.length;
        int min = A[0] + k;
        int max = A[n - 1] - k;
        int res = A[n - 1] - A[0];

        for (int i = 0; i < n - 1; i++) {
            int nMin = Math.min(min, A[i + 1] - k);
            int nMax = Math.max(max, A[i] + k);
            res = Math.min(res, nMax - nMin);
        }
        return res;
    }
}
