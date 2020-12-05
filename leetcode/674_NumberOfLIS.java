class Solution {
    public int findNumberOfLIS(int[] nums) {
        // 1, 3, 2, 4, 10, 5
        // 1, 2, 2, 3,  4, 4
        // 1, 1, 2, 1,  1, 2

        int n = nums.length;
        
        // len[i] = length of the LIS of nums[0] .... nums[i]
        int[] len = new int[n];

        // num[i] = number of LIS that end at nums[i]
        int[] num = new int[n];

        for (int i = 1; i < n; i++) {
            len[i] = num[i] = 1; // initial
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // The confusing bit
                    if (len[j] + 1 == len[i]) num[i] += num[j];
                    
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        num[i] = num[j];
                    }
                }
            }
        }

        return num[n - 1];
    }
}