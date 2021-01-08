class Solution {
  public int numIslands(char[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          ans++;
          depthFirstFill(grid, i, j);
        }
      }
    }
    return ans;
  }

  void depthFirstFill(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;

    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';
    depthFirstFill(grid, i + 1, j);
    depthFirstFill(grid, i - 1, j);
    depthFirstFill(grid, i, j + 1);
    depthFirstFill(grid, i, j - 1);
  }
}