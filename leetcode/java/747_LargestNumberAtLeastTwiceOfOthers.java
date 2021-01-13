class Solution {
  public int dominantIndex(int[] nums) {
    int maxSoFar = -1;
    int maxIdx = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == maxSoFar) {
        continue;
      }

      if (nums[i] > maxSoFar) {
        if (nums[i] >= 2 * maxSoFar) {
          maxIdx = i;
        } else {
          maxIdx = -1;
        }
        maxSoFar = nums[i];
      } else if (maxSoFar < 2 * nums[i]) {
        maxIdx = -1;
      }
    }

    return maxIdx;
  }
}