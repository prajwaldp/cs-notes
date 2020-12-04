class Solution {
    public int minimumEffort(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                int diff1 = a[1] - a[0];
                int diff2 = b[1] - b[0];

                if (diff1 == diff2) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(diff2, diff1);
            }
        });

        for (int[] task: tasks) {
            pq.offer(task);
        }

        int total = 0; // Total energy needed
        int left = 0; // energy currently left

        while (!pq.isEmpty()) {
            int[] task = pq.poll(); // next task
            if (left < task[1]) {
                total += task[1] - left;
                left = task[1];
            }
            left -= task[0];
        }

        return total;
    }
}