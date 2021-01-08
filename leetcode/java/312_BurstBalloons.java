class Solution {
    int[][] cache;
    public int maxCoins(int[] nums) { 
        int n = nums.length;
        int[] balloons = new int[n + 2];

        cache = new int[n + 2][n + 2];
        for (int[] c: cache) Arrays.fill(c, -1);
        
        int j = 0;
        balloons[j++] = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                balloons[j++] = nums[i];
            }
        }
        balloons[j] = 1;

        return maxCoins(balloons, 0, j);
    }

    private int maxCoins(int[] balloons, int l, int r) {
        if (cache[l][r] != -1) return cache[l][r];
        int maxScore = 0;
        for (int i = l + 1; i <= r - 1; i++) {
            int score = balloons[l] * balloons[i] * balloons[r] +
                maxCoins(balloons, l, i) + maxCoins(balloons, i, r);
            
            maxScore = Math.max(maxScore, score);
        }
        cache[l][r] = maxScore;
        return maxScore;
    }
}

