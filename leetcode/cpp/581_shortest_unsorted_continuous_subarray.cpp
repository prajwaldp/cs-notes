class Solution {
  public:
    int findUnsortedSubarray(vector<int> &nums) {
        int n = nums.size();
        int max_val = nums[0], min_val = nums[n - 1];
        int start = -1, end = -2;

        for (int i = 0; i < n; i++) {
            int j = n - i - 1;

            max_val = max(nums[i], max_val);
            if (nums[i] < max_val) {
                end = i;
            }

            min_val = min(nums[j], min_val);
            if (nums[j] > min_val) {
                start = j;
            }
        }

        return end - start + 1;
    }
};