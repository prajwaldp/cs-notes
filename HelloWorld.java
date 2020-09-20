import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void solve() throws IOException {
		int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		System.out.println(Arrays.stream(nums).sum());
	}

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		int numTestCases = Integer.parseInt(br.readLine());
		while (--numTestCases >= 0) {
			solution.solve();
		}
	}
}
