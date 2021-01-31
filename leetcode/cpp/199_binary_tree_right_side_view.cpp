class Solution
{
public:
    vector<int> rightSideView(TreeNode *root)
    {
        vector<int> res;
        dfs(root, res, 0);
        return res;
    }

    void dfs(TreeNode *root, vector<int> &res, int currLevel)
    {
        if (root == nullptr)
            return;

        if (currLevel == res.size())
            res.push_back(root->val);

        dfs(root->right, res, currLevel + 1);
        dfs(root->left, res, currLevel + 1);
    }
};
