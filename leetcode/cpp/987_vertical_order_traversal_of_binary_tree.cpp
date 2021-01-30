class Solution {
private:
    int startX = INT_MAX;
    int endX = INT_MIN;
    unordered_map<int, map<int, map<int, int>>> elements;

public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        dfs(root, 0, 0);
        vector<vector<int>> result;
        for (int col = startX; col <= endX; col++) {
            vector<int> colData;
            for (auto& [row, elemSet]: elements[col]) {
                for (auto [elem, count]: elemSet) {
                    while (count-- > 0) colData.push_back(elem);
                }
            }
            result.push_back(colData);
        }
        return result;
    }

    void dfs(TreeNode *root, int x, int y) {
        if (root == nullptr) return;
        startX = min(startX, x);
        endX = max(endX, x);
        
        elements[x][y][root->val]++;
        dfs(root->left, x - 1, y + 1);
        dfs(root->right, x + 1, y + 1);
    }
};

