class Solution {
  public int missingElement(int[] nums, int k) {
    int n = nums.length;
    int lo = 0;
    int hi = n;  // returning lo - 1 in the end

    int missing = 0;  // number of missing elements at that index

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;

      int positionIfNoMissingElement = nums[mid] - nums[0];  // 0-based
      missing = positionIfNoMissingElement - mid;

      if (missing >= k) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    int lastNumberBeforeKthMissing = nums[lo - 1];
    int toAddToGetKthMissing = k - (nums[lo - 1] - nums[0] - lo + 1); // same formula as above

    return lastNumberBeforeKthMissing + toAddToGetKthMissing;
  }
}
