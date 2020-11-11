import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void solve() throws IOException {
        int inp[] = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int m = inp[0], n = inp[1], a = inp[2];

        long ans = (long)(Math.ceil((double)m / a) * Math.ceil((double)n / a));
        System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

		// int numTestCases = Integer.parseInt(br.readLine());
        // while (--numTestCases >= 0) solution.solve();

        solution.solve();
	}
}
