class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

class Solution {
    private int ans = 0;
    
    private boolean isPseudoPalindrome(int[] count) {
        int oddCount = 0;
        for (int c: count) {
            if (c % 2 == 1) {
                if (++oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(TreeNode root, int[] count) {
        if (root == null) {
            return;
        }
        
        count[root.val]++;
        
        if (root.left == null && root.right == null) {
            if (isPseudoPalindrome(count)) {
                ans++;
            }
        }

        dfs(root.left, count);
        dfs(root.right, count);
        count[root.val]--;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        dfs(root, count);
        return ans;
    }
}
