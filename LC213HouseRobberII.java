import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;
import java.io.IOException;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * [0 1 2 ............n - 2, n - 1] Ideally: dp[i] = max(dp[i - 1], dp[i - 2] +
     * nums[i])
     *
     */

    private int rob(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int i = lo; i <= hi; i++) {
            int prevInclude = include;
            include = exclude + nums[i];
            exclude = Math.max(exclude, prevInclude);

            // System.out.println(i + ": include - " + include + ", exclude - " + exclude);
        }

        return Math.max(include, exclude);
    }

    void solve(int[] nums) {
        int n = nums.length;

        int rob0 = rob(nums, 0, n - 2);
        int robNminus1 = rob(nums, 1, n - 1);
        int dontRob0andNminus1 = rob(nums, 1, n - 2);

        System.out.println("Rob 0: " + rob0);
        System.out.println("Rob n - 1: " + robNminus1);
        System.out.println("Don't rob 0 or n - 1: " + dontRob0andNminus1);

        System.out.println(Stream.of(rob0, robNminus1, dontRob0andNminus1).max(Integer::compare).get());
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
