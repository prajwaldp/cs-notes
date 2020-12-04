class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        tails[0] = nums[0];

        int size = 1;

        for (int i = 1; i < n; i++) {
            int lo = 0, hi = size - 1;
            
            if (nums[i] > tails[hi]) {
                tails[size++] = nums[i];
                continue;
            }
            
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] > nums[i]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            tails[lo] = nums[i];

            // int lo = 0, hi = size;
            // while (lo < hi) {
            //     int mid = lo + (hi - lo) / 2;
            //     if (tails[mid] >= nums[i]) {
            //         hi = mid;
            //     } else {
            //         lo = mid + 1;
            //     }
            // }
            // tails[lo] = nums[i];
            // if (lo == size) size++;
        }

        return size;
    }
}
