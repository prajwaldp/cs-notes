import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return new int[0];
        }
        int m = matrix[0].length;
        int[] diagonal = new int[n * m];

        final int TOP_RIGHT = 0;
        final int BOTTOM_LEFT = 1;

        int direction = TOP_RIGHT;

        int r = 0, c = 0;
        for (int i = 0; i < n * m; i++) {
            // System.out.printf("r = %d, c = %d, dir = %d\n", r, c, direction);
            diagonal[i] = matrix[r][c];

            if (direction == TOP_RIGHT) {
                r--; c++;
                if (r == -1 && c == m) {
                    r = 1;
                    c = m - 1;
                    direction = BOTTOM_LEFT;
                } else if (r == -1) {
                    r = 0;
                    direction = BOTTOM_LEFT;
                } else if (c == m) {
                    c = m - 1;
                    r += 2;
                    direction = BOTTOM_LEFT;
                }
            } else {
                r++; c--;
                if (c == -1 && r == n) {
                    c = 1;
                    r = n - 1;
                    direction = TOP_RIGHT;
                } else if (c == -1) {
                    c = 0;
                    direction = TOP_RIGHT;
                } else if (r == n) {
                    r = n - 1;
                    c += 2;
                    direction = TOP_RIGHT;
                }
            }
        }
        return diagonal;
    }

    public static void main(String[] args) {
        var s = new Solution();
        int[][] input1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(Arrays.toString(s.findDiagonalOrder(input1)));

        int[][] input2 = { {1, 2} };
        System.out.println(Arrays.toString(s.findDiagonalOrder(input2)));

        int[][] input3 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println(Arrays.toString(s.findDiagonalOrder(input3)));
    }
}

