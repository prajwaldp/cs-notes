// Similar to 1060. Missing Element in Sorted Array

class Solution {
  public int findKthPositive(int[] nums, int k) {
    int n = nums.length;
    int lo = 0;
    int hi = n;

    int missingCount = 0;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int idealPosition = nums[mid] - 1; // 0-based
      missingCount = idealPosition - mid;

      if (missingCount >= k) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    if (lo == 0) {
      return k;
    }

    int numBeforeKthMissing = nums[lo - 1];
    int toAdd = k - (nums[lo - 1] - lo);  // (nums[lo - 1] - 1 - (lo - 1))
    return numBeforeKthMissing + toAdd;
  }
}