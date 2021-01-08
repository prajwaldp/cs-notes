#include <vector>

using namespace std;

class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid);
    int cherryPickup(vector<vector<int>>& grid, int n, int r1, int c1, int r2, int c2);
private:
    int dp[50][50][50][50];
};

int Solution::cherryPickup(vector<vector<int>>& grid) {
    memset(dp, -1, sizeof dp);
    return max(0, cherryPickup(grid, grid.size(), 0, 0, 0, 0));
}

int Solution::cherryPickup(vector<vector<int>>& grid, int n, int r1, int c1, int r2, int c2) {
    // since we're only going down or right, no need to check for < 0
    if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
        return INT_MIN;
    }

    if (dp[r1][c1][r2][c2] != -1) {
        return dp[r1][c1][r2][c2];
    }

    // if person 1 reached the bottom right, return what's in there (could be 0 or 1)
    if (r1 == n - 1 && c1 == n - 1) {
        return dp[r1][c1][r2][c2] = grid[r1][c1];
    }

    // if person 2 reached the bottom right, return what's in there (could be 0 or 1)
    if (r2 == n - 1 && c2 == n - 1) {
        return dp[r1][c1][r2][c2] = grid[r2][c2];
    }

    int cherries;

    if (r1 == r2 && c1 == c2)
        cherries = grid[r1][c1];
    else
        cherries = grid[r1][c1] + grid[r2][c2];

    // Total number of possibilities
    // p1, p2 = (down, down), (down, right), (right, right), (right, down)

    return dp[r1][c1][r2][c2] = cherries + max(
            max(cherryPickup(grid, n, r1 + 1, c1, r2 + 1, c2), cherryPickup(grid, n, r1 + 1, c1, r2, c2 + 1)),
            max(cherryPickup(grid, n, r1, c1 + 1, r2, c2 + 1), cherryPickup(grid, n, r1, c1 + 1, r2 + 1, c2))
        );
}

int main() {
    Solution* s = new Solution();
    return 0;
}

