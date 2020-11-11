import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.io.IOException;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void solve(int[] nums) {
        /**
         * 2 7 9 3 1
         *
         * day 1 = 2, day 2 = 7
         *
         * day 3 = 9 + 2 = 11
         *
         * day 4 = 3 + 7 or 3 + 2
         *
         * day 5 = 1 + 11 or 1 + 9
         */

        if (nums.length <= 2) {
            OptionalInt ans = Arrays.stream(nums).max();
            if (ans.isPresent()) {
                System.out.println(ans.getAsInt());
            } else {
                System.out.println(0);
            }
            return;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        int ans = Math.max(dp[1], dp[2]);

        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
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
