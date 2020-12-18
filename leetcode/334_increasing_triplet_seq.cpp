#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool increasingTriplet(vector<int>&);
};

// My version
bool Solution::increasingTriplet(vector<int>& nums) {
    int min, secondMin;
    bool isMinSet, isSecondMinSet;
    for (int n: nums) {
        if (isSecondMinSet && n > secondMin) return true;
        if (!isMinSet || n <= min) {
            min = n;
            isMinSet = true;
        } else {
            secondMin = n;
            isSecondMinSet = true;
        }
    }
    return false;
}

// A good version
bool Solution::increasingTripletV2(vector<int> nums) {
    int min1 = INT_MAX, min2 = INT_MAX;
    for (int n: nums) {
        if (n <= min1) min1 = n;
        else if (n <= min2) min2 = n;
        return true;
    }
    return false;
}

int main() {
    vector<int> nums1 {2, 1, 5, 0, 4, 6}, nums2 {5, 4, 3, 2, 1};
    Solution* s;
    cout << s->increasingTriplet(nums1) << "\n";
    cout << s->increasingTriplet(nums2) << "\n";
}

