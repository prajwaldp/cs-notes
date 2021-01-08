#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>&, int);
};

vector<vector<int>> Solution::fourSum(vector<int>& nums, int target) {
    int n = nums.size();
    sort(nums.begin(), nums.end());
    vector<vector<int>> quadruplets;
   
    int k, start, end;
    
    for (int i = 0; i < n - 3; i++) {
        if (i > 0) while (i < n && nums[i] == nums[i - 1]) i++;
        for (int j = i + 1; j < n - 2; j++) {
            if (j > 0) while (j < n && nums[j] == nums[j - 1]) j++;
            k = target - nums[i] - nums[j];
            
            start = j + 1;
            end = n - 1;
            
            while (start < end) {
                if (nums[start] + nums[end] == k) {
                    quadruplets.push_back({nums[i], nums[j], nums[start], nums[end]});
                    start++; end--;
                    while (start < n && nums[start] == nums[start - 1]) start++;
                    while (end > j && nums[end] == nums[end + 1]) end--;
                } else if (nums[start] + nums[end] > k) {
                    end--;
                    while (end > j && nums[end] == nums[end + 1]) end--;
                } else {
                    start++;
                    while (start < n && nums[start] == nums[start - 1]) start++;
                }
            }
        }
    }
    return quadruplets;
}

int main() {
    vector<int> nums {1, 1, 0, 0, -1, 0, -2, 2};
    Solution *s;
    for (auto& r: s->fourSum(nums, 0)) {
        for (int i: r) cout << i << '\t';
        cout << '\n';
    }
}

[-1,-5,-5,-3,2,5,0,4]

[-5,-5,-3,-1,0,2,4,5]
