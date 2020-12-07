class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        int curr = 1;
        int[][] res = new int[n][n];
        
        while (left < right && top < bottom) {
            for (int i = left; i <= right; i++) res[top][i] = curr++;
            top++;
            for (int i = top; i <= bottom; i++) res[i][right] = curr++;
            right--;
            for (int i = right; i>= left; i--) res[bottom][i] = curr++;
            bottom--;
            for (int i = bottom; i >= top; i--) res[i][left] = curr++;
            left++;
        }
        
        if (n % 2 != 0) res[n / 2][n / 2] = curr;
        
        return res;
    }
}
