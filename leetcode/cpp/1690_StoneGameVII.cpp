#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int stoneGameVII(vector<int>&);
};

int dfs(vector<int>& stones, vector<int>& sums, vector<vector<int>>& memo, int l, int r) {
    if (l == r) {
        return 0;
    }
    if (memo[l][r] == 0) {
        int rangeSum = l > 0 ? sums[r] - sums[l - 1] : sums[r];
        memo[l][r] = max(rangeSum - stones[l] - dfs(stones, sums, memo, l + 1, r),
                rangeSum - stones[r] - dfs(stones, sums, memo, l, r - 1));
    }

    return memo[l][r];
}

int Solution::stoneGameVII(vector<int>& stones) {
    int n = stones.size();
    vector<int> sums(stones);
    for (int i = 1; i < n; i++) {
        sums[i] += sums[i - 1];
    }

    vector<vector<int>> memo(n, vector<int>(n, 0));
    return dfs(stones, sums, memo, 0, n - 1);
}

int main() {
    Solution *soln;
    vector<int> test {5, 4, 1, 3, 2};
    vector<int> test2 {7, 90, 5, 1, 100, 10, 10, 2};
    cout << soln->stoneGameVII(test) << '\n';
    cout << soln->stoneGameVII(test2) << '\n';
}
