import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void solve() throws IOException {
        int num = Integer.parseInt(br.readLine());

        if (num % 2 == 0 && num != 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
	}

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		int numTestCases = Integer.parseInt(br.readLine());
		while (--numTestCases >= 0) {
			solution.solve();
		}
	}
}
