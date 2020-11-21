class SearchInRotatedSortedArray {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[lo] < nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        } 
        
        return false;    
    }
}
