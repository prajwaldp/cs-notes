// TODO
// Don't create the second bitset every loop
// Precompute bitsets for all rows in a vector of bitsets instead

class Solution {
public:
    int countCornerRectangles(vector<vector<int>>& grid) {
        const int COL_LIMIT = 200;
        int m = grid.size(), n = grid[0].size();
        int ans = 0;

        bitset<COL_LIMIT> r1, r2;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) r1.set(j, grid[i][j]);
            
            for (int ii = i + 1; ii < m; ii++) {
                for (int j = 0; j < n; j++) r2.set(j, grid[ii][j]);

                int c = (r1 & r2).count();
                ans += c * (c - 1) / 2;
            }
        }
        

        return ans;
    }
};

