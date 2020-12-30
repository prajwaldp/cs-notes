class Solution {
    public int maxStudents(char[][] seats) {
        int nrows = seats.length;
        int ncols = seats[0].length;

        return dp(seats, nrows, ncols, 0, 0, 0);
    }

    private int dp(char[][] seats, int nrows, int ncols, int currPos, int prevRow, int currRow) {
        if (currPos == nrows * ncols) return 0;

        int row = currPos / ncols;
        int col = currPos % ncols;

        if (col == 0) {
            prevRow = currRow;
            currRow = 0;
        }

        int op1 = dp(seats, nrows, ncols, currPos + 1, prevRow, currRow);
        int op2 = 0;

        if (seats[row][col] == '.') {
            boolean canSeat = true;

            if (row == 0) {
                // First row
                // Just check that the seat to the left is not used
                if (col > 0 && (currRow & 1 << (col - 1)) != 0) {
                    canSeat = false;
                }
            } else {
                if (col == 0) {
                    // there is no top left seat
                    // there is no left seat
                    // there can only be a top right seat
                    if (col != ncols - 1 && (prevRow & 1 << (col + 1)) != 0) {
                        canSeat = false;
                    }
                } else if (col == ncols - 1) {
                    // there is no top right seat
                    // there could be a top left seat
                    // there could be a left seat
                    if (col > 0 && (prevRow & 1 << (col - 1)) != 0) {
                        canSeat = false;
                    }
                    if (col > 0 && (currRow & 1 << (col - 1)) != 0) {
                        canSeat = false;
                    }
                } else {
                    // all four checks
                    if ((currRow & 1 << (col - 1)) != 0 ||
                        (currRow & 1 << (col + 1)) != 0 ||
                        (prevRow & 1 << (col - 1)) != 0 ||
                        (prevRow & 1 << (col + 1)) != 0) {
                        
                        canSeat = false;
                    }
                }
            }

            if (canSeat) {
                op2 = 1 + dp(seats, nrows, ncols, currPos + 1, prevRow, currRow | 1 << col);
            }
        }

        return Math.max(op1, op2);
    }
}

