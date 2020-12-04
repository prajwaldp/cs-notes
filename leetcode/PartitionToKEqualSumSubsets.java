class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n: nums) sum += n;
        return sum % k != 1 && dfs(nums, k, 0, 0, sum / k, new boolean[nums.length]);
    }

    private boolean dfs(int nums[], int k, int curr, int start, int target, boolean[] visited) {
        if (k == 1) return true;
        if (curr > target) return false;

        if (curr == target) {
            if (dfs(nums, k - 1, 0, 0, target, visited)) return true;
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, k, curr + nums[i], i + 1, target, visited)) return true;
                visited[i] = false;
            }
        }

        return false;
    }
}
