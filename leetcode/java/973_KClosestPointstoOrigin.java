class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        double[] dist = new double[n];
        for (int i = 0; i < n; i++) {
            dist[i] = calcDist(points[i]);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> {
            return Double.compare(dist[y], dist[x]);
        });

        for (int i = 0; i < n; i++) {
            maxHeap.offer(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] closest = new int[k][2];
        for (int i = 0; i < k; i++) {
            int idx = maxHeap.poll();
            closest[i][0] = points[idx][0];
            closest[i][1] = points[idx][1];
        }

        return closest;
    }

    private double calcDist(int[] a) {
        return Math.sqrt(a[0] * a[0] - a[1] * a[1]);
    }
}