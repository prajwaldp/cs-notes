import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.io.IOException;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void solve(int amount, int[] coins) {

        // 1 2 3 4 5 6 7 8 9 10 11
        // 1 1 2 3 4 5 6 7 8 9 10 11
        // 2 1 1 2 2 3 3 4 4 5 5 6
        // 5 1 1 2 2 1 2 3 4 5 2 3

        // Example input
        // 2
        // 5
        // 1 2 5 => 1
        // 11
        // 1 2 5 => 3

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        // int ans = dp[amount] == Integer.MAX_VALUE ? dp[amount] : -1;
        System.out.println(Arrays.stream(dp).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
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
