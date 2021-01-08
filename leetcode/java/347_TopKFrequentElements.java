class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> {
            return x[1] - y[1];
        });

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            minHeap.offer(new int[] {num, count});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll()[0];
        }

        return topK;
    }
}
