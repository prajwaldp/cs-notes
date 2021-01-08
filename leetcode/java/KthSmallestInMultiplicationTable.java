class Solution {
    private int count(int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            while (i * n > k) n--;
            count += n;
        }
        return count;
    }
    
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (count(m, n, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
