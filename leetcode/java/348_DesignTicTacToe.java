// O(n) solution
// O(1) solution in the ruby folder
class TicTacToe {
  int[][] board;
  public TicTacToe(int n) {
    this.board = new int[n][n];
  }

  /**
   *
   * @param row
   * @param col
   * @param player is the player ID (can be 1 or 2)
   * @return The current winning condition, can be either:
   *   0: No one wins
   *   1: Player 1 wins
   *   2: Player 2 wins
   */
  public int move(int row, int col, int player) {
    int n = board.length;
    // Every move is legal, so no check is required
    board[row][col] = player;

    // Check the column
    boolean won = true;
    
    for (int r = 0; r < n; r++) {
      if (board[r][col] != player) {
        won = false;
        break;
      }
    }
    
    if (won) {
      return player;
    }

    // Check the row
    won = true;

    for (int c = 0; c < n; c++) {
      if (board[row][c] != player) {
        won = false;
        break;
      }
    }

    if (won) {
      return player;
    }
    
    won = true;
    for (int i = 0; i < n; i++) {
      if (board[i][i] != player) {
        won = false;
        break;
      }
    }
    
    if (won) {
      return player;
    }
    
    won = true;
    for (int i = 0; i < n; i++) {
      if (board[i][n - i - 1] != player) {
        won = false;
        break;
      }
    }

    if (won) {
      return player;
    }
  
    return 0;
  }
}
