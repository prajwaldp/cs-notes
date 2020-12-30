class Solution {
    final int ALIVE_TO_DEAD = 3;
    final int DEAD_TO_ALIVE = 2;

    final int[][] neighbors = {
        {-1, -1},
        {-1,  0},
        {-1,  1},
        { 0, -1},
        { 0,  1},
        { 1, -1},
        { 1,  0},
        { 1,  1}
    };
    
    public void gameOfLife(int[][] board) {
        int nrows = board.length;
        int ncols = board[0].length;

        for (int r = 0; r < nrows; r++) {
            for (int c = 0; c < ncols; c++) {
                int liveNeighbors = getLiveNeighbors(board, r, c);

                // Will definitely reach an unaltered cell
                
                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[r][c] = ALIVE_TO_DEAD;
                } else if (board[r][c] == 0 && liveNeighbors == 3) {
                    board[r][c] = DEAD_TO_ALIVE;
                }
            }
        }
        
        for (int r = 0; r < nrows; r++) {
            for (int c = 0; c < ncols; c++) {
                if (board[r][c] == ALIVE_TO_DEAD) {
                    board[r][c] = 0;
                } else if (board[r][c] == DEAD_TO_ALIVE) {
                    board[r][c] = 1;
                }
            }
        }
    }

    private int getLiveNeighbors(int[][] board, int r, int c) {
        int nrows = board.length;
        int ncols = board[0].length;

        int liveNeighborCount = 0;
        
        for (int[] neighbor: neighbors) {
            int deltaR = r + neighbor[0];
            int deltaC = c + neighbor[1];

            if (deltaR >= 0 && deltaR < nrows && deltaC >= 0 && deltaC < ncols) {
                // 1 and 3 (ALIVE_TO_DEAD) are odd
                if (board[deltaR][deltaC] % 2 == 1) {
                    liveNeighborCount++;
                }
            }
        }
        
        return liveNeighborCount;
    }
}
