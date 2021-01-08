// 1. The order of picking the cherries does not matter
// 2. Can we move one robot to the bottom row and then start with the other
// For each state of the first robot, there would be an optimal state of the second robot

#include <vector>

using namespace std;

class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid);
    int cherryPickup(vector<vector<int>>& grid, int r1, int r2, int row);

private:
    int dp[71][71][71];
};

int Solution::cherryPickup(vector<vector<int>>& grid) {
    int n = grid[0].size();
    int r1 = 0, r2 = n - 1;

    memset(dp, -1, sizeof dp);
    return cherryPickup(grid, r1, r2, 0);
}

int Solution::cherryPickup(vector<vector<int>>& grid, int r1, int r2, int row) {
    if (row >= grid.size() ||
            r1 < 0 || r1 >= grid[0].size() || r2 < 0 || r2 >= grid[0].size()) {
        return 0;
    }
    
    if (dp[row][r1][r2] != -1) {
        return dp[row][r1][r2];
    }
    
    int cherries = r1 == r2 ? grid[row][r1] : grid[row][r1] + grid[row][r2];
    int maxCherries = INT_MIN;
    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            maxCherries = max(maxCherries,
                    cherries + cherryPickup(grid, r1 + i, r2 + j, row + 1));
        }
    }
    return dp[row][r1][r2] = maxCherries;
}
