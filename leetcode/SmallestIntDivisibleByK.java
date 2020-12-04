class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k == 2 || k == 5) return -1;
        int r = 0;
        for (int n = 1; n <= k; n++) {
            r = (r * 10 + 1) % k;
            if (r == 0) return n;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] testCases = new int[][] {
            {1, 1},
            {3, 3},
            {7, 6},
        };
        for (int[] t: testCases) {
            int got = s.smallestRepunitDivByK(t[0]);
            System.out.printf("Expected %d, got %d\n", t[1], got);
        }
    }
}
