import java.util.*;

class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid: cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                if (a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            }
        });

        int n = cuboids.length;
        int[] dp = new int[n];
        int ans = dp[0] = cuboids[0][2];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // is the current cuboid a better base?
                dp[i] = Math.max(dp[i], cuboids[i][2]);
                
                // if can place cuboid[i] over cuboid[j] 
                if (cuboids[i][0] >= cuboids[j][0] &&
                    cuboids[i][1] >= cuboids[j][1] &&
                    cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] cuboids = {
            {50, 45, 20},
            {95, 37, 53},
            {45, 23, 12}
        };

        System.out.println(s.maxHeight(cuboids));
    }
}

