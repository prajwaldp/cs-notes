/*
 * dp[row][col1][col2] = Math.max(
 * dp[row - 1][col1][col2 - 1],
 * dp[row - 1][col1][col2]
 * dp[row - 1][col1][col2 + 1]
 * ... 6 more items
 * )
 */

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        
        dp[0][0][n - 1] = 0 == n - 1 ? grid[0][0] : grid[0][0] + grid[0][n - 1];

        int ans = 0;
        
        for (int row = 1; row < m; row++) {
            for (int col1 = 0; col1 < Math.min(n, row + 1); col1++) {
                for (int col2 = n - 1; col2 >= Math.max(0, n - 1 - row); col2--) {
                    int prevMax = 0;

                    for (int offset1 = -1; offset1 <= 1; offset1++) {
                        for (int offset2 = -1; offset2 <= 1; offset2++) {
                            int prevCol1 = col1 + offset1;
                            int prevCol2 = col2 + offset2;

                            if (prevCol1 < 0 || prevCol1 >= n || prevCol2 < 0 || prevCol2 >= n) {
                                continue;
                            }

                            prevMax = Math.max(prevMax, dp[row - 1][prevCol1][prevCol2]);
                        }
                    }

                    dp[row][col1][col2] = prevMax + (col1 == col2 ? grid[row][col1] :
                            grid[row][col1] + grid[row][col2]);

                    if (row == m - 1) {
                        ans = Math.max(ans, dp[row][col1][col2]);
                    }
                }
            }
        }

        return ans;
    }
}
