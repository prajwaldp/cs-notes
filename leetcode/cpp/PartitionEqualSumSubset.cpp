class Solution {
public:
    bool canPartition(vector<int>& nums) {
        const int MAX_LEN = 200;
        const int MAX_NUM = 100;

        bitset<MAX_NUM * MAX_LEN / 2 + 1> bits(1); // A sum of zero is possible
        int sum = 0;
        for (int n: nums) {
            sum += n;
            bits |= bits << n;
        }

        return !(sum % 2 != 0) && bits[sum / 2];
    }
};
