import java.util.Arrays;

public class KthSmallestPairDist {
    /**
     * Counts the number of pairs in nums whose absolute difference is <= k.
     * @param nums
     * @param k
     * @return the number of pairs whose abs diff <= k
     */
    private int countPairs(final int[] nums, final int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] <= k) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public int smallestDistancePair(final int[] nums, int k) {
        Arrays.sort(nums);

        int lo = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            lo = Math.min(lo, nums[i] - nums[i - 1]);
        }
        int hi = nums[nums.length - 1] - nums[0];
        int mid = 0;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int nPairs = countPairs(nums, mid);
            if (nPairs <= k) {
                hi = mid;
            } else {
                lo = mid + 1;
                k -= nPairs;
            }
        }

        return mid;
    }
}
