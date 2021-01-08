#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
    int fourSumCount(vector<int>&, vector<int>&, vector<int>&, vector<int>&);
};

int Solution::fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
    unordered_map<int, int> abFreq; 
    for (int a: A) {
        for (int b: B) {
            abFreq[a + b]++;
        }
    }
    int ans = 0;
    for (int c: C) {
        for (int d: D) {
            auto res = abFreq.find(-c - d);
            if (res != abFreq.end()) {
                ans += res->second;
            }
        }
    }
    return ans;
}

