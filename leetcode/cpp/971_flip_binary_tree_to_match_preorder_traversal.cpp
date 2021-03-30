class Solution {
public:
    vector<int> ans;
    int v_id = 0;
    bool is_possible = true;
    
    vector<int> flipMatchVoyage(TreeNode* root, vector<int>& voyage) {
        dfs(root, voyage);
        return is_possible ? ans : vector<int>(1, -1);
    }
    
    void dfs(TreeNode* curr, vector<int>& voyage) {
        if (curr == nullptr || v_id == voyage.size())
            return;
        
        if (curr->val != voyage[v_id]) {
            is_possible = false;
            return;
        }
        
        v_id++;
        
        if (curr->left != nullptr && curr->left->val != voyage[v_id]) {
            ans.push_back(curr->val);
            
            TreeNode* tmp = curr->left;
            curr->left = curr->right;
            curr->right = tmp;
        }
        
        dfs(curr->left, voyage);
        dfs(curr->right, voyage);
    }
};
