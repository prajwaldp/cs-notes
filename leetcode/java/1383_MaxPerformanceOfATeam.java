/**
 * n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 *
 * s:  2 10  3  1  5  8
 * e:  5  4  3  9  7  2
 *
 * Performance = sum of speed / min (efficieny)
 */

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficieny[i];
        }
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
        System.out.println(Arrays.toString(engineers));
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        maxPerformance(n, speed, efficiency, k);
    }
}

