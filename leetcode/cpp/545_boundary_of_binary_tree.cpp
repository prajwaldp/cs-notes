class Solution
{
public:
    vector<int> boundaryOfBinaryTree(TreeNode *root)
    {
        vector<int> res;
        if (root == nullptr)
            return res;

        res.push_back(root->val);

        leftBoundary(root->left, res);
        leaves(root->left, res);
        leaves(root->right, res);
        rightBoundary(root->right, res);

        return res;
    }

    void leftBoundary(TreeNode *root, vector<int> &res)
    {
        if (root == nullptr || (root->left == nullptr && root->right == nullptr))
            return;

        res.push_back(root->val);

        if (root->left == nullptr)
            leftBoundary(root->right, res);
        else
            leftBoundary(root->left, res);
    }

    void rightBoundary(TreeNode *root, vector<int> &res)
    {
        if (root == nullptr || (root->left == nullptr && root->right == nullptr))
            return;

        if (root->right == nullptr)
            rightBoundary(root->left, res);
        else
            rightBoundary(root->right, res);

        res.push_back(root->val);
    }

    void leaves(TreeNode *root, vector<int> &res)
    {
        if (root == nullptr)
            return;

        if (root->left == nullptr && root->right == nullptr)
        {
            res.push_back(root->val);
            return;
        }

        leaves(root->left, res);
        leaves(root->right, res);
    }
};
