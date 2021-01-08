class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] maxWin = new int[n - k + 1];
        
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.getLast() < nums[i]) q.removeLast();
            q.addLast(nums[i]);

            if (i >= k - 1) {
                int max = q.getFirst();
                maxWin[i - k + 1] = max;
                if (nums[i - k + 1] == max) q.removeFirst();
            }
        }
        
        return maxWin;
    }
}
