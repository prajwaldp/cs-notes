class Solution {
    public void setZeroes(int[][] matrix) {
        int nrows = matrix.length;
        int ncols = matrix[0].length;

        boolean setFirstCol = false;

        /*
         * X X 0 X
         * X X X X
         * X X X X
         * a b c d
         *
         * In the traversal, matrix[0][0] is set to 0
         * In the second traversal, a is set to 0 too
         * Avoid this by setting the first column only if
         *      a zero element exists in the first column of the original matrix
         */

        for (int r = 0; r < nrows; r++) {
            if (matrix[r][0] == 0) {
                setFirstCol = true;
            }
            
            for (int c = 1; c < ncols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = matrix[0][c] = 0;
                }
            }
        }

        for (int r = nrows - 1; r >= 0; r--) {
            for (int c = ncols - 1; c > 0; c--) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
            if (setFirstCol) {
                matrix[r][0] = 0;
            }
        }
    }
}
