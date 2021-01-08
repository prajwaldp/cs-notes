#include <vector>
#include <iostream>

using namespace std;

class Solution {
    public:
        vector<int> sortedSquares(vector<int>& nums) {
            int n = nums.size();
            vector<int> res(n);
            int i = 0, j, k = 0;
            while (i < n && nums[i] < 0) i++;
            j = i - 1;
            while (i < n && j >= 0) {
                if (abs(nums[i]) < abs(nums[j])) {
                    res[k++] = pow(nums[i++], 2);
                } else {
                    res[k++] = pow(nums[j--], 2);
                }
            }

            while (i < n) res[k++] = pow(nums[i++], 2);
            while (j >= 0) res[k++] = pow(nums[j--], 2);
            return res;
        }
};

int main() {
    vector<int> nums = {-4, -1, 0, 3, 10};
    Solution* s;
    for (int i: s->sortedSquares(nums)) cout << i << " "; cout << "\n";
    return 0;
}

