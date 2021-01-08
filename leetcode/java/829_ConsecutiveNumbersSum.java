// k term sum starting with x: (x + 0) + (x + 1) + (x + 2) + ... + (x + (k - 1)) = N
// kx + k(k-1)/2 = N
// kx = N - k(k-1)/2
// 1. The RHS is a multiple of k => rhs % k = 0
// 2. Starting range for k = 1 (the consecutive numbers can have 1 term)
// (or) starting range can be k = 2, with the initial answer = 1
// 3. Ending range for k: kx > 0 => N - k(k - 1)/2 > 0 => k(k - 1) < 2N

class Solution {
    int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int k = 1; k * (k - 1) < 2 * N; k++) {
            int rhs = N - k * (k - 1) / 2;
            if (rhs % k == 0) {
                ans++;
            }
        }
        return ans;
    }
}

