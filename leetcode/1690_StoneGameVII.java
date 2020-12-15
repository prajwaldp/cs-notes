class Solution {
    void dfs(int[] stones, int l, int r, int sum, int turn) {
        if (turn == 0) {
            alice += Math.max(sum - s:w
        }

    }
    
    public int stoneGameVII(int[] stones) {
        int sum = 0;
        for (int s: stones) sum += s;
        dfs(stones, 0, stones.length - 1, sum, 0);
    }
}
