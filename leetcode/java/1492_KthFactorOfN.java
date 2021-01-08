import java.util.List;

class Solution {
    // public int kthFactor(int n, int k) {
    //     for (int i = 1; i <= n / 2; i++) {
    //         if (n % i == 0 && --k == 0) return i;
    //     }
    //     return k == 1 ? n : -1;
    // }

    // 100 => 1, 2, 4, 5, [10], 20, 25, 50, 100

    public int kthFactor(int n, int k) {
        // Each d produces two factors - d and n / d
        double root = Math.sqrt(n);
        int d;
        
        for (d = 1; d <= root; d++) {
            if (n % d == 0 && --k == 0) return d;
        }
        
        for (d = d - 1; d >= 1; --d) {
            if (d == root) continue;
            if (n % d == 0 && --k == 0) return n / d;
        }
        
        return -1;
    }
}