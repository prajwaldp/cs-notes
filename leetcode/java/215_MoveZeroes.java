import java.util.*;

class Solution {
  public void moveZeroes(int[] nums) {
    int n = nums.length;
    int j = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        if (j <= i) {
          j = i + 1;
        }
        while (j < n && nums[j] == 0) {
          j++;
        }
        if (j == n) {
          return;
        }
        swap(nums, i, j);
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a1 = {0, 2, 4, 1, 6, 0, 2, 4, 8, 0};
    s.moveZeroes(a1);
    System.out.println(Arrays.toString(a1));
  }
}