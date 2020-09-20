import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void solve(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        System.out.println(dp[amount]);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int numTestCases = Integer.parseInt(br.readLine());
        while (--numTestCases >= 0) {
            int amount = Integer.parseInt(br.readLine());
            int[] coins = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            solution.solve(amount, coins);
        }
    }
}
