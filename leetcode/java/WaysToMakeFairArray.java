class Solution {
    public int waysToMakeFair(int[] nums) {
        /**
         * 6   1  7  4  1
         * 14  5  8  4  1
         */

        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        prefixSum[1] = nums[1];
        suffixSum[n - 1] = nums[n - 1];
        suffixSum[n - 2] = nums[n - 2];

        for (int i = 2; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 2];
        }

        for (int i = n - 3; i >= 0; i--) {
            suffixSum[i] = nums[i] + suffixSum[i + 2];
        }

        int preEven;
        int postEven;
        int preOdd;
        int postOdd;

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                preEven = i - 2 >= 0 ? prefixSum[i - 2] : 0;
                postEven = i + 1 < n ? suffixSum[i + 1] : 0;
                
                preOdd = i - 1 >= 0 ? prefixSum[i - 1] : 0;
                postOdd = i + 2 < n ? suffixSum[i + 2] : 0;
            } else {
                preEven = i - 1 >= 0 ? prefixSum[i - 1] : 0;
                postEven = i + 2 < n ? suffixSum[i + 2] : 0;
                
                preOdd = i - 2 >= 0 ? prefixSum[i - 2] : 0;
                postOdd = i + 1 < n ? suffixSum[i + 1] : 0;
            }

            if (preEven + postEven == preOdd + postOdd) {
                count++;
            }
        }

        return count;
    }
}