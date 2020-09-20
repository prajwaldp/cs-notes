import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;
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

    void solve(int[] nums) {
        System.out.println(Math.pow(2, 32));
        for (int n : nums) {
            System.out.println(Integer.toString(n, 2));
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int numTestCases = Integer.parseInt(br.readLine());
        while (--numTestCases >= 0) {
            int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            solution.solve(nums);
        }
    }
}
