import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int k, s, e;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0) {
                while (i < n && nums[i] == nums[i - 1]) {
                    i++;
                }
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1) {
                    while (j < n && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }

                k = target - nums[i] - nums[j];
                s = j + 1;
                e = n - 1;

                while (s < e) {
                    if (nums[s] + nums[e] == k) {
                        ans.add(List.of(nums[i], nums[j], nums[s], nums[e]));
                        s++; e--;
                        while (s < e && nums[s] == nums[s - 1]) s++;
                        while (s < e && nums[e] == nums[e + 1]) e--;
                    } else if (nums[s] + nums[e] < k) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        return ans;
    }
}

