class Solution {
  public int[][] candyCrush(int[][] board) {
    int m = board.length;
    int n = board[0].length;

    boolean shouldContinue = true;
    while (shouldContinue) {
      shouldContinue = false;

      // Process Rows
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n - 2; j++) {
          int v = Math.abs(board[i][j]);
          if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
            board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
            shouldContinue = true;
          }
        }
      }

      // Process columns
      for (int i = 0; i < m - 2; i++) {
        for (int j = 0; j < n; j++) {
          int v = Math.abs(board[i][j]);
          if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
            board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
            shouldContinue = true;
          }
        }
      }

      // Gravity Step (copy non -ve numbers down)
      for (int j = 0; j < n; j++) {
        int currentRow = m - 1;
        for (int i = m - 1; i >= 0; i--) {
          if (board[i][j] >= 0) {
            board[currentRow][j] = board[i][j];
            currentRow--;
          }
        }
        for (int i = currentRow; i >= 0; i--) {
          board[i][j] = 0;
        }
      }
    }

    return board;
  }
}