import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.io.IOException;

/**
 * @formatter:off

 * Things to remember:
 * ===================
 *
 * Going from the O(n^2) solution to the O(n) solution can be easy if you
 * remember that there's no point starting in between the previous start point
 * and the point of failure.
 *
 * Also, the check to see if a cycle can be completed is still not clear but I
 * guess it makes sense.
 *
 * @formatter:on
 */

class Solution {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int gasLeft = 0, start = 0;

    int f = IntStream.range(0, n).map(i -> gas[i] - cost[i]).sum();

    if (f < 0) {
      return -1;
    }

    for (int i = 0; i < n; i++) {
      gasLeft = gasLeft + gas[i] - cost[i];

      if (gasLeft < 0) {
        gasLeft = 0;
        start = i + 1;
      }

    }

    return start;
  }

  public static void main(String[] args) throws IOException {
    Solution solution = new Solution();
    int numTestCases = Integer.parseInt(br.readLine());
    while (--numTestCases >= 0) {
      int[] gas = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
      int[] cost = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
      System.out.println(solution.canCompleteCircuit(gas, cost));
    }
  }
}
