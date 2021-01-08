class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    if (n1 > n2) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int lo = 0;
    int hi = n1;

    while (lo <= hi) {
      // p1 + p2 = (n1 + n2 + 1) / 2
      int p1 = lo + (hi - lo) / 2;  // partition1
      int p2 = (n1 + n2 + 1) / 2 - p1;  // partition2

      int maxLeft1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
      int minRight1 = p1 == n1 ? Integer.MAX_VALUE : nums1[p1];

      int maxLeft2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
      int minRight2 = p2 == n2 ? Integer.MAX_VALUE : nums2[p2];

      if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
        if ((n1 + n2) % 2 == 0) {
          return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
        } else {
          return Math.max(maxLeft1, maxLeft2);
        }
      } else if (maxLeft1 > minRight2) {
        hi = p1 - 1;
      } else {
        lo = p1 + 1;
      }
    }

    return -1;
  }
}