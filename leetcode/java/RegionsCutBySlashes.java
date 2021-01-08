class Solution {
    public int regionsBySlashes(String[] grid) {        
        int m = grid.length;
        int n = grid[0].length();
        int count = 0;

        int[][] g = new int[m * 3][n * 3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        for (int i = 0; i < m * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (g[i][j] == 0) {
                    count++;
                    dfs(g, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) {
            return;
        }
        
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

class AlternateSolution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][][] g = new int[n][n][4];
        
        for (int i = 0; i < n; j++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '/') {
                    union(i - 1, j - 1);
                    union(i + 1, j + 1);
                } else if (ch == '\\') {
                    union(i - 1, j + 1);
                    union(i + 1, j - 1);
                } else {
                    // ch = ' '
                    
                }
            }
        }
    }
}
