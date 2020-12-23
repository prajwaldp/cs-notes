import java.util.*;
import java.io.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = (int)1e9 + 7;
        int n = arr.length;
        int[] nextLesserAt = new int[n];
        int[] prevLesserAt = new int[n];

        Arrays.fill(prevLesserAt, -1);

        // populate nextLesserAt
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.getFirst()] > arr[i])) {
                int top = stack.removeFirst();
                nextLesserAt[top] = i;
            }
            if (!stack.isEmpty()) {
                prevLesserAt[i] = stack.getFirst();
            }
            stack.addFirst(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int countLeft = i - prevLesserAt[i];
            int countRight = nextLesserAt[i] - i;
            // countLeft and countRight include the element
            sum = (sum + ((long)arr[i] * countLeft * countRight) % MOD) % MOD;
        }

        return (int)sum;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        var s = new Solution();
        var br = new BufferedReader(new FileReader("testcase.txt"));
        int[] testcase = Arrays.stream(br.readLine().split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int ans = s.sumSubarrayMins(testcase);
        System.out.println(ans);
    }
}
