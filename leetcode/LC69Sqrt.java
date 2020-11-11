import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * a = 1 0 0 1
     *
     * b = 1 1 0 0
     *
     * c = 0 1 1 1
     *
     * Pass 1: bestSoln = {a, b}
     *
     * Pass 2: bestSoln = {c}
     */

    void solve(int num) {
        int left = 1, right = num + 10, mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid * mid > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int numTestCases = Integer.parseInt(br.readLine());
        while (--numTestCases >= 0) {
            int num = Integer.parseInt(br.readLine());
            solution.solve(num);
        }
    }
}
