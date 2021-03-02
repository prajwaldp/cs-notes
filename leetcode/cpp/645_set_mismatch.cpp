// O(N) time + O(N) space
class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int m_xor_n = 0;
        int m = 0;
        vector<int> count(nums.size(), 0);
        
        for (int i = 1; i <= nums.size(); i++) {
            int n = nums[i - 1];
            m_xor_n ^= i ^ n;
            if (++count[n - 1] == 2) {
                m = n;
            }
        }
        return { m, m ^ m_xor_n };
    }
};

// No extra space
class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int m_xor_n = 0;
        int m = 0;
        vector<int> ans(2, 0);

        for (int i = 1; i <= nums.size(); i++) {
            int n = abs(nums[i - 1]);
            ans[1] ^= i ^ n;
            if (nums[n - 1] < 0) {
                ans[0] = n;
            } else {
                nums[n - 1] = -1 * nums[n - 1];
            }
        }
        
        ans[1] ^= ans[0];

        return ans;
    }
};
