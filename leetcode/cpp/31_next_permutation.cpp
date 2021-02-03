class Solution {
  public:
    void nextPermutation(vector<int> &nums) {
        int k = nums.size() - 2; // inversion point

        if (k <= -1)
            return;

        while (k >= 0 && nums[k] >= nums[k + 1])
            k--;

        if (k == -1) {
            sort(nums.begin(), nums.end());
            return;
        }

        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] > nums[k]) {
                swap(nums[i], nums[k]);
                break;
            }
        }

        int i = k + 1;
        int j = nums.size() - 1;

        while (i < j) {
            swap(nums[i], nums[j]);
            i++;
            j--;
        }
    }
};
