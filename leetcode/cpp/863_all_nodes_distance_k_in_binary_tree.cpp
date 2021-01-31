class Solution {
  public:
    vector<int> distanceK(TreeNode *root, TreeNode *target, int K) {
        if (K == 0) {
            return vector<int>{target->val};
        }
        unordered_map<TreeNode *, unordered_set<TreeNode *>> adjList;
        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty()) {
            TreeNode *parent = q.front();
            q.pop();

            if (parent->left != nullptr) {
                adjList[parent].insert(parent->left);
                adjList[parent->left].insert(parent);
                q.push(parent->left);
            }

            if (parent->right != nullptr) {
                adjList[parent].insert(parent->right);
                adjList[parent->right].insert(parent);
                q.push(parent->right);
            }
        }

        queue<TreeNode *> q2;
        q2.push(target);
        vector<int> ans;
        unordered_set<TreeNode *> visited;
        visited.insert(target);

        while (!q2.empty()) {
            int n = q2.size();
            while (n-- > 0) {
                TreeNode *p = q2.front();
                q2.pop();

                for (auto &c : adjList[p]) {
                    if (visited.find(c) == visited.end()) {
                        visited.insert(c);
                        q2.push(c);
                    }
                }
            }
            if (--K == 0) {
                while (!q2.empty()) {
                    ans.push_back(q2.front()->val);
                    q2.pop();
                }
            }
        }
        return ans;
    }
};
