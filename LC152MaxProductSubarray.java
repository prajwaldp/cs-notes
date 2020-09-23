import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;
import java.io.IOException;

/**
 * @TODO
 */

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 2 3 -2 4 -2 -1 2 6 - -
     */

    void solve(int[] nums) {
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
