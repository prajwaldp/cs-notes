bool Solution::isValidBST(TreeNode* root) {
    stack<TreeNode*> s;
    int prev = INT_MIN;
    bool prevSet = false;
    
    while (root != nullptr || !s.empty()) {
        while (root != nullptr) {
            s.push(root);
            root = root->left;
        }
        TreeNode* top = s.top(); s.pop();
        if (prevSet && top->val <= prev) {
            return false;
        }
        prev = top->val;
        prevSet = true;
        root = top->right;
    }
    return true;
}
